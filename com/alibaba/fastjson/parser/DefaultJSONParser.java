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
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
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
import java.util.Arrays;
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
    public int objectKeyLevel;
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
        primitiveClasses.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i2 = this.contextArrayIndex;
        this.contextArrayIndex = i2 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i2 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i2] = parseContext;
    }

    public final void accept(int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i2) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i2) + ", actual " + JSONToken.name(jSONLexer.token()));
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
        for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
            if (str.equals(this.contextArray[i2].toString())) {
                return this.contextArray[i2].object;
            }
        }
        return null;
    }

    public ParseContext getOwnerContext() {
        return this.context.parent;
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
        for (int i2 = 0; i2 < size; i2++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i2);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj3 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                obj2 = getObject(str);
                if (obj2 == null) {
                    try {
                        JSONPath compile = JSONPath.compile(str);
                        if (compile.isRef()) {
                            obj2 = compile.eval(obj);
                        }
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    Object obj4 = this.contextArray[0].object;
                    JSONPath compile2 = JSONPath.compile(str);
                    if (compile2.isRef()) {
                        obj2 = compile2.eval(obj4);
                    }
                }
                if (fieldDeserializer.getOwnerClass() != null && !fieldDeserializer.getOwnerClass().isInstance(obj3) && resolveTask.ownerContext.parent != null && fieldDeserializer.getOwnerClass().isInstance(resolveTask.ownerContext.parent.object)) {
                    obj3 = resolveTask.ownerContext.parent.object;
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

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0289, code lost:
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0294, code lost:
        if (r4.token() != 13) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0296, code lost:
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02a1, code lost:
        if ((r17.config.getDeserializer(r7) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02a3, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r7, r17.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02aa, code lost:
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02ab, code lost:
        if (r0 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02af, code lost:
        if (r7 != java.lang.Cloneable.class) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02b1, code lost:
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02bd, code lost:
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02bf, code lost:
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02ca, code lost:
        if ("java.util.Collections$UnmodifiableMap".equals(r6) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02cc, code lost:
        r0 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02d6, code lost:
        r0 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02dd, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02de, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02e6, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02e7, code lost:
        setResolveStatus(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02ed, code lost:
        if (r17.context == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02ef, code lost:
        if (r19 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02f3, code lost:
        if ((r19 instanceof java.lang.Integer) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02fb, code lost:
        if ((r17.context.fieldName instanceof java.lang.Integer) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02fd, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0304, code lost:
        if (r18.size() <= 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0306, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r7, r17.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0316, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0317, code lost:
        r0 = r17.config.getDeserializer(r7);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0327, code lost:
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x032b, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x032f, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0331, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0338, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x033a, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0345, code lost:
        return r0.deserialze(r17, r7, r19);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0217 A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0455 A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0480 A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04dc A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05e0 A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05ec A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05f8 A[Catch: all -> 0x0698, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x060d A[Catch: all -> 0x0698, TRY_ENTER, TryCatch #2 {all -> 0x0698, blocks: (B:24:0x0072, B:26:0x0076, B:29:0x0080, B:32:0x0093, B:36:0x00ab, B:115:0x0217, B:116:0x021d, B:118:0x0228, B:120:0x0230, B:124:0x0245, B:126:0x0253, B:141:0x0283, B:142:0x0289, B:144:0x0296, B:145:0x0299, B:147:0x02a3, B:152:0x02b1, B:153:0x02b7, B:155:0x02bf, B:156:0x02c4, B:158:0x02cc, B:159:0x02d6, B:163:0x02df, B:164:0x02e6, B:165:0x02e7, B:168:0x02f1, B:170:0x02f5, B:172:0x02fd, B:173:0x0300, B:175:0x0306, B:178:0x0317, B:184:0x0331, B:188:0x033e, B:185:0x0336, B:187:0x033a, B:128:0x025a, B:130:0x0260, B:135:0x026d, B:138:0x0273, B:195:0x0350, B:197:0x0356, B:199:0x035e, B:201:0x0368, B:203:0x0379, B:205:0x0384, B:207:0x038c, B:209:0x0390, B:211:0x0398, B:214:0x039d, B:216:0x03a1, B:239:0x0407, B:241:0x040f, B:244:0x0418, B:245:0x0432, B:218:0x03a8, B:220:0x03b0, B:222:0x03b4, B:223:0x03b7, B:224:0x03c3, B:227:0x03cc, B:229:0x03d0, B:230:0x03d3, B:232:0x03d7, B:233:0x03db, B:234:0x03e7, B:236:0x03f1, B:238:0x03fe, B:246:0x0433, B:247:0x0451, B:250:0x0455, B:252:0x0459, B:254:0x045f, B:256:0x0465, B:257:0x0468, B:261:0x0470, B:267:0x0480, B:269:0x048f, B:271:0x049a, B:272:0x04a2, B:273:0x04a5, B:285:0x04d1, B:287:0x04dc, B:291:0x04e9, B:294:0x04f9, B:295:0x0519, B:280:0x04b5, B:282:0x04bf, B:284:0x04ce, B:283:0x04c4, B:298:0x051e, B:300:0x0528, B:302:0x0530, B:303:0x0533, B:305:0x053e, B:306:0x0542, B:308:0x054d, B:311:0x0554, B:314:0x055d, B:315:0x0562, B:318:0x0567, B:320:0x056c, B:324:0x0577, B:326:0x057f, B:328:0x0594, B:332:0x05b3, B:334:0x05bb, B:337:0x05c1, B:339:0x05c7, B:341:0x05cf, B:344:0x05e0, B:347:0x05e8, B:349:0x05ec, B:350:0x05f3, B:352:0x05f8, B:353:0x05fb, B:355:0x0603, B:358:0x060d, B:361:0x0617, B:362:0x061c, B:363:0x0621, B:364:0x063b, B:329:0x059f, B:330:0x05a6, B:365:0x063c, B:367:0x064e, B:370:0x0655, B:373:0x0663, B:374:0x0683, B:39:0x00bd, B:40:0x00db, B:43:0x00e0, B:45:0x00eb, B:47:0x00ef, B:49:0x00f5, B:51:0x00fb, B:52:0x00fe, B:59:0x010d, B:61:0x0115, B:64:0x0125, B:65:0x013d, B:66:0x013e, B:67:0x0143, B:78:0x0158, B:79:0x015e, B:81:0x0165, B:83:0x016e, B:90:0x0180, B:93:0x0188, B:94:0x01a0, B:88:0x017b, B:82:0x016a, B:95:0x01a1, B:96:0x01b9, B:102:0x01c3, B:104:0x01cb, B:107:0x01dc, B:108:0x01fc, B:109:0x01fd, B:110:0x0202, B:111:0x0203, B:113:0x020d, B:375:0x0684, B:376:0x068b, B:377:0x068c, B:378:0x0691, B:379:0x0692, B:380:0x0697), top: B:387:0x0072, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0603 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:413:0x04e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        Object parse;
        boolean z;
        Object decimalValue;
        char current;
        Map jSONObject;
        boolean z2;
        Object obj2;
        Number decimalValue2;
        Object obj3;
        char current2;
        Object fluentPut;
        Object obj4;
        Class<?> cls;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() == 4 && jSONLexer.stringVal().length() == 0) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONLexer.info());
        } else {
            ParseContext parseContext = this.context;
            try {
                boolean z3 = map instanceof JSONObject;
                Map<String, Object> innerMap = z3 ? ((JSONObject) map).getInnerMap() : map;
                boolean z4 = false;
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
                    boolean z5 = true;
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
                        if (!z4) {
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
                                if (!jSONLexer.isEnabled(Feature.NonStringKeyAsString)) {
                                    if (z3) {
                                    }
                                    parse = decimalValue;
                                    if (jSONLexer.getCurrent() == ':') {
                                        throw new JSONException("parse number key error" + jSONLexer.info());
                                    }
                                }
                                decimalValue = decimalValue.toString();
                                parse = decimalValue;
                                if (jSONLexer.getCurrent() == ':') {
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
                            int i2 = this.objectKeyLevel;
                            this.objectKeyLevel = i2 + 1;
                            if (i2 <= 512) {
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
                                            cls = map.getClass();
                                            obj4 = null;
                                        } else {
                                            for (int i3 = 0; i3 < scanSymbol.length(); i3++) {
                                                char charAt = scanSymbol.charAt(i3);
                                                if (charAt >= '0' && charAt <= '9') {
                                                }
                                                z5 = false;
                                            }
                                            if (z5) {
                                                obj4 = null;
                                                cls = null;
                                            } else {
                                                obj4 = null;
                                                cls = this.config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                                            }
                                        }
                                        if (cls != null) {
                                            break;
                                        }
                                        innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol);
                                    }
                                } else if (parse != "$ref" && parseContext != null && ((map == null || map.size() == 0) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
                                    jSONLexer.nextToken(4);
                                    if (jSONLexer.token() == 4) {
                                        String stringVal = jSONLexer.stringVal();
                                        jSONLexer.nextToken(13);
                                        if (jSONLexer.token() == 16) {
                                            innerMap.put(parse, stringVal);
                                        } else {
                                            if ("@".equals(stringVal)) {
                                                if (this.context != null) {
                                                    ParseContext parseContext2 = this.context;
                                                    Object obj5 = parseContext2.object;
                                                    if (!(obj5 instanceof Object[]) && !(obj5 instanceof Collection)) {
                                                        if (parseContext2.parent != null) {
                                                            fluentPut = parseContext2.parent.object;
                                                        }
                                                    }
                                                    fluentPut = obj5;
                                                }
                                                fluentPut = null;
                                            } else if (IStringUtil.TOP_PATH.equals(stringVal)) {
                                                if (parseContext.object != null) {
                                                    fluentPut = parseContext.object;
                                                } else {
                                                    addResolveTask(new ResolveTask(parseContext, stringVal));
                                                    setResolveStatus(1);
                                                    fluentPut = null;
                                                }
                                            } else if ("$".equals(stringVal)) {
                                                ParseContext parseContext3 = parseContext;
                                                while (parseContext3.parent != null) {
                                                    parseContext3 = parseContext3.parent;
                                                }
                                                if (parseContext3.object != null) {
                                                    fluentPut = parseContext3.object;
                                                } else {
                                                    addResolveTask(new ResolveTask(parseContext3, stringVal));
                                                    setResolveStatus(1);
                                                    fluentPut = null;
                                                }
                                            } else if (JSONPath.compile(stringVal).isRef()) {
                                                addResolveTask(new ResolveTask(parseContext, stringVal));
                                                setResolveStatus(1);
                                                fluentPut = null;
                                            } else {
                                                fluentPut = new JSONObject().fluentPut("$ref", stringVal);
                                            }
                                            if (jSONLexer.token() == 13) {
                                                jSONLexer.nextToken(16);
                                                return fluentPut;
                                            }
                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                        }
                                    } else {
                                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                                    }
                                } else {
                                    if (!z4) {
                                        if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                            parseContext = this.context;
                                        } else {
                                            ParseContext context2 = setContext(map, obj);
                                            if (parseContext == null) {
                                                parseContext = context2;
                                            }
                                            z4 = true;
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
                                        boolean z6 = obj != null && obj.getClass() == Integer.class;
                                        if (jSONLexer.isEnabled(Feature.CustomMapDeserializer)) {
                                            MapDeserializer mapDeserializer = (MapDeserializer) this.config.getDeserializer(Map.class);
                                            if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
                                                jSONObject = mapDeserializer.createMap(Map.class, jSONLexer.getFeatures());
                                            } else {
                                                jSONObject = mapDeserializer.createMap(Map.class);
                                            }
                                        } else {
                                            jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                                        }
                                        ParseContext context3 = !z6 ? setContext(this.context, jSONObject, parse) : null;
                                        if (this.fieldTypeResolver != null) {
                                            Type resolve = this.fieldTypeResolver.resolve(map, parse != null ? parse.toString() : null);
                                            if (resolve != null) {
                                                obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, parse);
                                                z2 = true;
                                                if (!z2) {
                                                    obj2 = parseObject(jSONObject, parse);
                                                }
                                                if (context3 != null && jSONObject != obj2) {
                                                    context3.object = map;
                                                }
                                                if (parse != null) {
                                                    checkMapResolve(map, parse.toString());
                                                }
                                                innerMap.put(parse, obj2);
                                                if (z6) {
                                                    setContext(obj2, parse);
                                                }
                                                if (jSONLexer.token() != 13) {
                                                    jSONLexer.nextToken();
                                                    setContext(parseContext);
                                                    return map;
                                                } else if (jSONLexer.token() != 16) {
                                                    throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                                } else if (z6) {
                                                    popContext();
                                                } else {
                                                    setContext(parseContext);
                                                }
                                            }
                                        }
                                        z2 = false;
                                        obj2 = null;
                                        if (!z2) {
                                        }
                                        if (context3 != null) {
                                            context3.object = map;
                                        }
                                        if (parse != null) {
                                        }
                                        innerMap.put(parse, obj2);
                                        if (z6) {
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
                            } else {
                                throw new JSONException("object key level > 512");
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
                    if (!z4) {
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
        int i2 = this.contextArrayIndex;
        if (i2 <= 0) {
            return;
        }
        int i3 = i2 - 1;
        this.contextArrayIndex = i3;
        this.contextArray[i3] = null;
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i2 >= parseContextArr.length || i2 >= this.contextArrayIndex) {
                break;
            }
            ParseContext parseContext = parseContextArr[i2];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i2++;
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
        setDateFormat(dateFormat);
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i2) {
        this.resolveStatus = i2;
    }

    public void throwException(int i2) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i2) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token();
        if (i2 == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i2 == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i2 == 4) {
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
        } else if (i2 != 12) {
            if (i2 == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i2 == 18) {
                if (WalletPayViewController.DEF_CHANNEL_TITLE.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    return null;
                }
                throw new JSONException("syntax error, " + jSONLexer.info());
            } else if (i2 != 26) {
                switch (i2) {
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
                        switch (i2) {
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

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i2) {
        this(str, new JSONScanner(str, i2), parserConfig);
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

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(char[] cArr, int i2, ParserConfig parserConfig, int i3) {
        this(cArr, new JSONScanner(cArr, i2, i3), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i2 = this.lexer.token();
        if (i2 == 21 || i2 == 22) {
            this.lexer.nextToken();
            i2 = this.lexer.token();
        }
        if (i2 == 14) {
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
            int i3 = 0;
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
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i3));
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
                    i3++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i2) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.lexer.info());
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

    public final void accept(int i2, int i3) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i2) {
            jSONLexer.nextToken(i3);
        } else {
            throwException(i2);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
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
        Class cls2;
        int i2 = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i3 = 14;
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
            int i4 = 0;
            while (i4 < typeArr.length) {
                if (this.lexer.token() == i2) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i4];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i4 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.lexer.token() != 4)) {
                                z = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z = false;
                            }
                            if (z && this.lexer.token() != i3) {
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
                                cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i4));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i4] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i4 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i4++;
                    i2 = 8;
                    i3 = 14;
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
        int i2 = 0;
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
                    if (i2 != 0) {
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
                    int i3 = this.lexer.token();
                    if (i3 == 20 || i3 == 15) {
                        break;
                    } else if (i3 == 13) {
                        this.lexer.nextToken();
                        return propertyProcessable;
                    }
                }
                i2++;
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
            if (parseContext != null && parseContext.level > 512) {
                throw new JSONException("array level > 512");
            }
            ParseContext parseContext2 = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i3 = jSONLexer.token();
                    Number number = null;
                    number = null;
                    if (i3 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        number = integerValue;
                    } else if (i3 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        number = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i3 == 4) {
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
                    } else if (i3 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        number = bool;
                    } else if (i3 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        number = bool2;
                    } else if (i3 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i3 == 12) {
                        number = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i2));
                    } else if (i3 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else {
                        if (i3 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i3 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i2));
                            number = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                number = jSONArray.toArray();
                            }
                        } else if (i3 != 15) {
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
                    i2++;
                } finally {
                    setContext(parseContext2);
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
        int i2 = this.lexer.token();
        if (i2 == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i2 == 4) {
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
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() == JavaBeanDeserializer.class) {
                if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
                return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
            }
            return (T) deserializer.deserialze(this, type, obj);
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
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map) parseObject);
    }
}
