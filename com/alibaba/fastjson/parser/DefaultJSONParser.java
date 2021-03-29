package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public static final Set<Class<?>> primitiveClasses = new HashSet();
    public String[] autoTypeAccept;
    public boolean autoTypeEnable;
    public ParserConfig config;
    public ParseContext context;
    public ParseContext[] contextArray;
    public int contextArrayIndex;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public List<ExtraProcessor> extraProcessors;
    public List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    public List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: classes.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() == 4) {
            if (str.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    return;
                }
                return;
            }
            throw new JSONException("type not match error");
        }
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) this.input);
        }
        return obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj3 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                obj2 = getObject(str);
                if (obj2 == null) {
                    try {
                        obj2 = JSONPath.eval(obj, str);
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    obj2 = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (Object.class.equals(type3)) {
                    if (wildcardType.getLowerBounds().length == 0) {
                        return parse();
                    }
                    throw new JSONException("not support type : " + type);
                }
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class) type3, (Collection) arrayList2);
                return arrayList2;
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        }
        throw new JSONException("not support type " + type);
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraTypeProvider : list) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor extraProcessor : list2) {
                extraProcessor.processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0243, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x024e, code lost:
        if (r5.token() != 13) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0250, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0253, code lost:
        r0 = r16.config.getDeserializer(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x025b, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025d, code lost:
        r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
        r2 = r0.createInstance(r16, r8);
        r3 = r9.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x026f, code lost:
        if (r3.hasNext() == false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0271, code lost:
        r4 = (java.util.Map.Entry) r3.next();
        r5 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x027d, code lost:
        if ((r5 instanceof java.lang.String) == false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x027f, code lost:
        r5 = r0.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0285, code lost:
        if (r5 == null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0287, code lost:
        r5.setValue(r2, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x028f, code lost:
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0290, code lost:
        if (r2 != null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0294, code lost:
        if (r8 != java.lang.Cloneable.class) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0296, code lost:
        r2 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a2, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a4, code lost:
        r2 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a9, code lost:
        r2 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02b0, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02b9, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02ba, code lost:
        setResolveStatus(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02c0, code lost:
        if (r16.context == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02c2, code lost:
        if (r18 == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02c6, code lost:
        if ((r18 instanceof java.lang.Integer) != false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02ce, code lost:
        if ((r16.context.fieldName instanceof java.lang.Integer) != false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02d0, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02d7, code lost:
        if (r17.size() <= 0) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02d9, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r8, r16.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02e5, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02f3, code lost:
        return r16.config.getDeserializer(r8).deserialze(r16, r8, r18);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e9 A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03bd A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03e8 A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0444 A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0511 A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x051d A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0529 A[Catch: all -> 0x05be, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x053e A[Catch: all -> 0x05be, TRY_ENTER, TryCatch #1 {all -> 0x05be, blocks: (B:18:0x005f, B:20:0x0063, B:23:0x006d, B:26:0x0080, B:30:0x0098, B:101:0x01e9, B:102:0x01ef, B:104:0x01fa, B:106:0x0202, B:110:0x0216, B:112:0x0224, B:115:0x0237, B:117:0x0243, B:119:0x0250, B:120:0x0253, B:122:0x025d, B:123:0x026b, B:125:0x0271, B:127:0x027f, B:129:0x0287, B:134:0x0296, B:135:0x029c, B:137:0x02a4, B:138:0x02a9, B:142:0x02b2, B:143:0x02b9, B:144:0x02ba, B:147:0x02c4, B:149:0x02c8, B:151:0x02d0, B:152:0x02d3, B:154:0x02d9, B:157:0x02e6, B:113:0x022a, B:164:0x02fb, B:166:0x0303, B:168:0x030d, B:170:0x031e, B:172:0x0322, B:174:0x032a, B:177:0x032f, B:179:0x0333, B:199:0x0385, B:201:0x038d, B:204:0x0396, B:205:0x039b, B:181:0x033a, B:183:0x0342, B:185:0x0346, B:186:0x0349, B:187:0x0355, B:190:0x035e, B:192:0x0362, B:193:0x0365, B:195:0x0369, B:196:0x036d, B:197:0x0379, B:206:0x039c, B:207:0x03ba, B:209:0x03bd, B:211:0x03c1, B:213:0x03c7, B:215:0x03cd, B:216:0x03d0, B:220:0x03d8, B:226:0x03e8, B:228:0x03f7, B:230:0x0402, B:231:0x040a, B:232:0x040d, B:244:0x0439, B:246:0x0444, B:250:0x0451, B:253:0x0461, B:254:0x0481, B:239:0x041d, B:241:0x0427, B:243:0x0436, B:242:0x042c, B:257:0x0486, B:259:0x0490, B:261:0x0496, B:262:0x0499, B:264:0x04a4, B:265:0x04a8, B:267:0x04b3, B:270:0x04ba, B:273:0x04c3, B:274:0x04c8, B:277:0x04cd, B:279:0x04d2, B:283:0x04db, B:285:0x04e8, B:287:0x04ee, B:290:0x04f4, B:292:0x04fa, B:294:0x0502, B:297:0x0511, B:300:0x0519, B:302:0x051d, B:303:0x0524, B:305:0x0529, B:306:0x052c, B:308:0x0534, B:311:0x053e, B:314:0x0548, B:315:0x054d, B:316:0x0552, B:317:0x056c, B:318:0x056d, B:320:0x057f, B:323:0x0586, B:326:0x0591, B:327:0x05b1, B:33:0x00aa, B:34:0x00c8, B:37:0x00cd, B:39:0x00d8, B:41:0x00dc, B:43:0x00e2, B:45:0x00e8, B:46:0x00eb, B:53:0x00fa, B:55:0x0102, B:58:0x0112, B:59:0x012a, B:60:0x012b, B:61:0x0130, B:72:0x0145, B:73:0x014b, B:75:0x0152, B:78:0x015c, B:81:0x0164, B:82:0x017c, B:76:0x0157, B:83:0x017d, B:84:0x0195, B:90:0x019f, B:92:0x01a7, B:95:0x01b8, B:96:0x01d8, B:97:0x01d9, B:98:0x01de, B:99:0x01df, B:328:0x05b2, B:329:0x05b7, B:330:0x05b8, B:331:0x05bd), top: B:337:0x005f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0534 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x044d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        Object parse;
        boolean z;
        Object decimalValue;
        char current;
        Object obj2;
        Number decimalValue2;
        Object obj3;
        char current2;
        Object obj4;
        Object obj5;
        Class<?> checkAutoType;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONLexer.info());
        } else {
            ParseContext parseContext = this.context;
            try {
                Map<String, Object> innerMap = map instanceof JSONObject ? ((JSONObject) map).getInnerMap() : map;
                boolean z2 = false;
                while (true) {
                    jSONLexer.skipWhitespace();
                    char current3 = jSONLexer.getCurrent();
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (current3 == ',') {
                            jSONLexer.next();
                            jSONLexer.skipWhitespace();
                            current3 = jSONLexer.getCurrent();
                        }
                    }
                    boolean z3 = true;
                    if (current3 == '\"') {
                        parse = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + parse);
                        }
                    } else if (current3 == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken();
                        if (!z2) {
                            if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                parseContext = this.context;
                            } else {
                                ParseContext context = setContext(map, obj);
                                if (parseContext == null) {
                                    parseContext = context;
                                }
                            }
                        }
                        return map;
                    } else if (current3 == '\'') {
                        if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                            parse = jSONLexer.scanSymbol(this.symbolTable, '\'');
                            jSONLexer.skipWhitespace();
                            if (jSONLexer.getCurrent() != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.pos());
                            }
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (current3 == 26) {
                        throw new JSONException("syntax error");
                    } else {
                        if (current3 == ',') {
                            throw new JSONException("syntax error");
                        }
                        if ((current3 >= '0' && current3 <= '9') || current3 == '-') {
                            jSONLexer.resetStringPosition();
                            jSONLexer.scanNumber();
                            try {
                                if (jSONLexer.token() == 2) {
                                    decimalValue = jSONLexer.integerValue();
                                } else {
                                    decimalValue = jSONLexer.decimalValue(true);
                                }
                                parse = decimalValue;
                                if (jSONLexer.getCurrent() != ':') {
                                    throw new JSONException("parse number key error" + jSONLexer.info());
                                }
                            } catch (NumberFormatException unused) {
                                throw new JSONException("parse number key error" + jSONLexer.info());
                            }
                        } else {
                            if (current3 != '{' && current3 != '[') {
                                if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                                    parse = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                                    jSONLexer.skipWhitespace();
                                    char current4 = jSONLexer.getCurrent();
                                    if (current4 != ':') {
                                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current4);
                                    }
                                } else {
                                    throw new JSONException("syntax error");
                                }
                            }
                            jSONLexer.nextToken();
                            parse = parse();
                            z = true;
                            if (!z) {
                                jSONLexer.next();
                                jSONLexer.skipWhitespace();
                            }
                            current = jSONLexer.getCurrent();
                            jSONLexer.resetStringPosition();
                            if (parse != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                                if (!jSONLexer.isEnabled(Feature.IgnoreAutoType)) {
                                    if (map != null && map.getClass().getName().equals(scanSymbol)) {
                                        checkAutoType = map.getClass();
                                        obj5 = null;
                                    } else {
                                        obj5 = null;
                                        checkAutoType = this.config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                                    }
                                    if (checkAutoType != null) {
                                        break;
                                    }
                                    innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol);
                                } else {
                                    obj5 = null;
                                }
                            } else if (parse != "$ref" && parseContext != null && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                jSONLexer.nextToken(4);
                                if (jSONLexer.token() == 4) {
                                    String stringVal = jSONLexer.stringVal();
                                    jSONLexer.nextToken(13);
                                    if ("@".equals(stringVal)) {
                                        if (this.context != null) {
                                            ParseContext parseContext2 = this.context;
                                            Object obj6 = parseContext2.object;
                                            if (!(obj6 instanceof Object[]) && !(obj6 instanceof Collection)) {
                                                if (parseContext2.parent != null) {
                                                    obj4 = parseContext2.parent.object;
                                                }
                                            }
                                            obj4 = obj6;
                                        }
                                        obj4 = null;
                                    } else if (IStringUtil.TOP_PATH.equals(stringVal)) {
                                        if (parseContext.object != null) {
                                            obj4 = parseContext.object;
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext, stringVal));
                                            setResolveStatus(1);
                                            obj4 = null;
                                        }
                                    } else {
                                        if ("$".equals(stringVal)) {
                                            ParseContext parseContext3 = parseContext;
                                            while (parseContext3.parent != null) {
                                                parseContext3 = parseContext3.parent;
                                            }
                                            if (parseContext3.object != null) {
                                                obj4 = parseContext3.object;
                                            } else {
                                                addResolveTask(new ResolveTask(parseContext3, stringVal));
                                                setResolveStatus(1);
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext, stringVal));
                                            setResolveStatus(1);
                                        }
                                        obj4 = null;
                                    }
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken(16);
                                        return obj4;
                                    }
                                    throw new JSONException("syntax error");
                                }
                                throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                            } else {
                                if (!z2) {
                                    if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                        parseContext = this.context;
                                    } else {
                                        ParseContext context2 = setContext(map, obj);
                                        if (parseContext == null) {
                                            parseContext = context2;
                                        }
                                        z2 = true;
                                    }
                                }
                                if (map.getClass() == JSONObject.class && parse == null) {
                                    parse = StringUtil.NULL_STRING;
                                }
                                if (current != '\"') {
                                    jSONLexer.scanString();
                                    String stringVal2 = jSONLexer.stringVal();
                                    Number number = stringVal2;
                                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                        JSONScanner jSONScanner = new JSONScanner(stringVal2);
                                        Date date = stringVal2;
                                        if (jSONScanner.scanISO8601DateIfMatch()) {
                                            date = jSONScanner.getCalendar().getTime();
                                        }
                                        jSONScanner.close();
                                        number = date;
                                    }
                                    innerMap.put(parse, number);
                                    obj3 = number;
                                } else if ((current >= '0' && current <= '9') || current == '-') {
                                    jSONLexer.scanNumber();
                                    if (jSONLexer.token() == 2) {
                                        decimalValue2 = jSONLexer.integerValue();
                                    } else {
                                        decimalValue2 = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                                    }
                                    innerMap.put(parse, decimalValue2);
                                    obj3 = decimalValue2;
                                } else if (current == '[') {
                                    jSONLexer.nextToken();
                                    Collection jSONArray = new JSONArray();
                                    if (obj != null) {
                                        obj.getClass();
                                    }
                                    if (obj == null) {
                                        setContext(parseContext);
                                    }
                                    parseArray(jSONArray, parse);
                                    Object[] objArr = jSONArray;
                                    if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                        objArr = jSONArray.toArray();
                                    }
                                    innerMap.put(parse, objArr);
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken();
                                        return map;
                                    } else if (jSONLexer.token() != 16) {
                                        throw new JSONException("syntax error");
                                    }
                                } else if (current == '{') {
                                    jSONLexer.nextToken();
                                    boolean z4 = obj != null && obj.getClass() == Integer.class;
                                    Map jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                                    ParseContext context3 = !z4 ? setContext(parseContext, jSONObject, parse) : null;
                                    if (this.fieldTypeResolver != null) {
                                        Type resolve = this.fieldTypeResolver.resolve(map, parse != null ? parse.toString() : null);
                                        if (resolve != null) {
                                            obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, parse);
                                            if (!z3) {
                                                obj2 = parseObject(jSONObject, parse);
                                            }
                                            if (context3 != null && jSONObject != obj2) {
                                                context3.object = map;
                                            }
                                            if (parse != null) {
                                                checkMapResolve(map, parse.toString());
                                            }
                                            innerMap.put(parse, obj2);
                                            if (z4) {
                                                setContext(obj2, parse);
                                            }
                                            if (jSONLexer.token() != 13) {
                                                jSONLexer.nextToken();
                                                setContext(parseContext);
                                                return map;
                                            } else if (jSONLexer.token() != 16) {
                                                throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                            } else if (z4) {
                                                popContext();
                                            } else {
                                                setContext(parseContext);
                                            }
                                        }
                                    }
                                    obj2 = null;
                                    z3 = false;
                                    if (!z3) {
                                    }
                                    if (context3 != null) {
                                        context3.object = map;
                                    }
                                    if (parse != null) {
                                    }
                                    innerMap.put(parse, obj2);
                                    if (z4) {
                                    }
                                    if (jSONLexer.token() != 13) {
                                    }
                                } else {
                                    jSONLexer.nextToken();
                                    innerMap.put(parse, parse());
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken();
                                        return map;
                                    } else if (jSONLexer.token() != 16) {
                                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + parse);
                                    }
                                }
                                jSONLexer.skipWhitespace();
                                current2 = jSONLexer.getCurrent();
                                if (current2 == ',') {
                                    if (current2 == '}') {
                                        jSONLexer.next();
                                        jSONLexer.resetStringPosition();
                                        jSONLexer.nextToken();
                                        setContext(obj3, parse);
                                        return map;
                                    }
                                    throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + parse);
                                }
                                jSONLexer.next();
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    current = jSONLexer.getCurrent();
                    jSONLexer.resetStringPosition();
                    if (parse != JSON.DEFAULT_TYPE_KEY) {
                    }
                    if (parse != "$ref") {
                    }
                    if (!z2) {
                    }
                    if (map.getClass() == JSONObject.class) {
                        parse = StringUtil.NULL_STRING;
                    }
                    if (current != '\"') {
                    }
                    jSONLexer.skipWhitespace();
                    current2 = jSONLexer.getCurrent();
                    if (current2 == ',') {
                    }
                }
            } finally {
                setContext(parseContext);
            }
        }
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                break;
            }
            ParseContext parseContext = parseContextArr[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i++;
        }
        return null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i != 12) {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i == 18) {
                if (WalletPayViewController.DEF_CHANNEL_TITLE.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    return null;
                }
                throw new JSONException("syntax error, " + jSONLexer.info());
            } else if (i != 26) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken();
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken();
                        return Boolean.FALSE;
                    case 8:
                        jSONLexer.nextToken();
                        return null;
                    case 9:
                        jSONLexer.nextToken(18);
                        if (jSONLexer.token() == 18) {
                            jSONLexer.nextToken(10);
                            accept(10);
                            long longValue = jSONLexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, " + jSONLexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray(hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray(treeSet, obj);
                                return treeSet;
                            case 23:
                                jSONLexer.nextToken();
                                return null;
                            default:
                                throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                }
            } else {
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
            }
        } else {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(i) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i3];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i3 == typeArr.length - 1 && (type instanceof Class)) {
                                Class cls2 = (Class) type;
                                z = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z = false;
                            }
                            if (z && this.lexer.token() != i2) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0236, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object parse(PropertyProcessable propertyProcessable, Object obj) {
        String scanSymbolUnQuoted;
        int i = 0;
        if (this.lexer.token() != 12) {
            String str = "syntax error, expect {, actual " + this.lexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + StringUtil.ARRAY_ELEMENT_SEPARATOR) + this.lexer.info();
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            if (jSONArray.size() == 1) {
                Object obj2 = jSONArray.get(0);
                if (obj2 instanceof JSONObject) {
                    return (JSONObject) obj2;
                }
            }
            throw new JSONException(str2);
        }
        ParseContext parseContext = this.context;
        while (true) {
            try {
                this.lexer.skipWhitespace();
                char current = this.lexer.getCurrent();
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        this.lexer.next();
                        this.lexer.skipWhitespace();
                        current = this.lexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, Typography.quote);
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (current == '}') {
                    this.lexer.next();
                    this.lexer.resetStringPosition();
                    this.lexer.nextToken(16);
                    return propertyProcessable;
                } else if (current == '\'') {
                    if (this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
                        scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\'');
                        this.lexer.skipWhitespace();
                        if (this.lexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + this.lexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    scanSymbolUnQuoted = this.lexer.scanSymbolUnQuoted(this.symbolTable);
                    this.lexer.skipWhitespace();
                    char current2 = this.lexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + current2);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                this.lexer.next();
                this.lexer.skipWhitespace();
                this.lexer.getCurrent();
                this.lexer.resetStringPosition();
                Object obj3 = null;
                if (scanSymbolUnQuoted == JSON.DEFAULT_TYPE_KEY && !this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    Class<?> checkAutoType = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, Typography.quote), null, this.lexer.getFeatures());
                    if (Map.class.isAssignableFrom(checkAutoType)) {
                        this.lexer.nextToken(16);
                        if (this.lexer.token() == 13) {
                            this.lexer.nextToken(16);
                            return propertyProcessable;
                        }
                    } else {
                        ObjectDeserializer deserializer = this.config.getDeserializer(checkAutoType);
                        this.lexer.nextToken(16);
                        setResolveStatus(2);
                        if (parseContext != null && !(obj instanceof Integer)) {
                            popContext();
                        }
                        return (Map) deserializer.deserialze(this, checkAutoType, obj);
                    }
                } else {
                    this.lexer.nextToken();
                    if (i != 0) {
                        setContext(parseContext);
                    }
                    Type type = propertyProcessable.getType(scanSymbolUnQuoted);
                    if (this.lexer.token() == 8) {
                        this.lexer.nextToken();
                    } else {
                        obj3 = parseObject(type, scanSymbolUnQuoted);
                    }
                    propertyProcessable.apply(scanSymbolUnQuoted, obj3);
                    setContext(parseContext, obj3, scanSymbolUnQuoted);
                    setContext(parseContext);
                    int i2 = this.lexer.token();
                    if (i2 == 20 || i2 == 15) {
                        break;
                    } else if (i2 == 13) {
                        this.lexer.nextToken();
                        return propertyProcessable;
                    }
                }
                i++;
            } finally {
                setContext(parseContext);
            }
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i2 = jSONLexer.token();
                    Number number = null;
                    number = null;
                    if (i2 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        number = integerValue;
                    } else if (i2 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        number = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i2 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        number = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            number = date;
                        }
                    } else if (i2 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        number = bool;
                    } else if (i2 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        number = bool2;
                    } else if (i2 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i2 == 12) {
                        number = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                    } else if (i2 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else {
                        if (i2 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i));
                            number = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                number = jSONArray.toArray();
                            }
                        } else if (i2 != 15) {
                            number = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(number);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i++;
                } finally {
                    setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }
}
