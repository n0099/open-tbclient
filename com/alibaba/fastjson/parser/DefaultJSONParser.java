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
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes5.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        for (Class<?> cls : new Class[]{Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class}) {
            primitiveClasses.add(cls);
        }
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
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

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        return this.input instanceof char[] ? new String((char[]) this.input) : this.input.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [592=10] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0278, code lost:
        r10.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0283, code lost:
        if (r10.token() != 13) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0285, code lost:
        r10.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x028b, code lost:
        r1 = r14.config.getDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0293, code lost:
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0295, code lost:
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
        r5 = r1.createInstance(r14, r6);
        r8 = r2.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02a7, code lost:
        if (r8.hasNext() == false) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02a9, code lost:
        r2 = (java.util.Map.Entry) r8.next();
        r3 = r2.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02b5, code lost:
        if ((r3 instanceof java.lang.String) == false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02b7, code lost:
        r3 = r1.getFieldDeserializer((java.lang.String) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02bd, code lost:
        if (r3 == null) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02bf, code lost:
        r3.setValue(r5, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c7, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02d0, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02d1, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02d2, code lost:
        if (r1 != null) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02d6, code lost:
        if (r6 != java.lang.Cloneable.class) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02d8, code lost:
        r1 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02dd, code lost:
        setContext(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02ea, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02ec, code lost:
        r1 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02f1, code lost:
        r1 = r6.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f7, code lost:
        setResolveStatus(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02fc, code lost:
        if (r14.context == null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02fe, code lost:
        if (r16 == null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0304, code lost:
        if ((r16 instanceof java.lang.Integer) != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030c, code lost:
        if ((r14.context.fieldName instanceof java.lang.Integer) != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030e, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0315, code lost:
        if (r15.size() <= 0) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0317, code lost:
        r15 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r15, (java.lang.Class<java.lang.Object>) r6, r14.config);
        parseObject(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x063f, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:?, code lost:
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:?, code lost:
        return r14.config.getDeserializer(r6).deserialze(r14, r6, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r4 != null) goto L383;
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0410 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x046a A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x053e A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x054a A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0556 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0571 A[Catch: all -> 0x00ca, TRY_ENTER, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0437 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0561 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d9 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:16:0x005a, B:18:0x005e, B:20:0x0069, B:24:0x007c, B:28:0x008e, B:30:0x00a1, B:31:0x00c9, B:94:0x01d9, B:95:0x01df, B:97:0x01ea, B:99:0x01f2, B:102:0x0204, B:104:0x0212, B:106:0x0219, B:116:0x0278, B:118:0x0285, B:120:0x028b, B:122:0x0295, B:123:0x02a3, B:125:0x02a9, B:127:0x02b7, B:129:0x02bf, B:138:0x02d8, B:140:0x02e3, B:142:0x02ec, B:143:0x02f1, B:132:0x02c8, B:133:0x02d0, B:146:0x02f7, B:149:0x0300, B:151:0x0306, B:153:0x030e, B:154:0x0311, B:156:0x0317, B:158:0x0325, B:115:0x026b, B:163:0x033d, B:165:0x0345, B:167:0x0350, B:169:0x0363, B:171:0x0367, B:173:0x036f, B:181:0x0386, B:177:0x0375, B:179:0x037d, B:180:0x0385, B:203:0x03e2, B:183:0x038a, B:184:0x038f, B:186:0x0398, B:188:0x039c, B:189:0x03a0, B:190:0x03ae, B:193:0x03b8, B:195:0x03bc, B:196:0x03bf, B:198:0x03c3, B:200:0x03c7, B:201:0x03d4, B:205:0x03ec, B:206:0x040d, B:208:0x0410, B:210:0x0414, B:212:0x041c, B:214:0x0422, B:215:0x0425, B:221:0x0437, B:223:0x0446, B:225:0x0451, B:226:0x0459, B:227:0x045c, B:228:0x045f, B:230:0x046a, B:317:0x05f7, B:319:0x0608, B:320:0x0630, B:241:0x0486, B:243:0x0490, B:244:0x0494, B:245:0x0498, B:248:0x04a7, B:250:0x04b1, B:253:0x04bb, B:254:0x04be, B:256:0x04c9, B:257:0x04cd, B:259:0x04d8, B:261:0x04e0, B:264:0x04eb, B:265:0x04f3, B:268:0x04f8, B:270:0x04fd, B:273:0x0507, B:275:0x0515, B:276:0x051a, B:279:0x0522, B:280:0x0526, B:282:0x052e, B:284:0x053e, B:287:0x0546, B:289:0x054a, B:290:0x0551, B:292:0x0556, B:293:0x0559, B:295:0x0561, B:299:0x0571, B:302:0x057b, B:303:0x0581, B:304:0x0587, B:305:0x05a4, B:306:0x05a5, B:308:0x05b7, B:310:0x05bf, B:313:0x05ca, B:314:0x05f2, B:231:0x0470, B:37:0x00d3, B:39:0x00de, B:41:0x00e2, B:43:0x00ea, B:45:0x00f0, B:47:0x00f7, B:52:0x0103, B:54:0x010b, B:55:0x0113, B:56:0x0114, B:58:0x0127, B:59:0x0144, B:62:0x0149, B:63:0x0151, B:66:0x0156, B:67:0x015e, B:74:0x016b, B:75:0x0171, B:77:0x0178, B:78:0x017c, B:80:0x0184, B:81:0x01a1, B:83:0x01a3, B:86:0x01a9, B:87:0x01c6, B:107:0x0220, B:109:0x0228, B:110:0x0230, B:111:0x0231, B:113:0x0242, B:114:0x026a, B:92:0x01cf), top: B:331:0x005a, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        ParseContext parseContext;
        boolean z;
        Object obj2;
        char current;
        boolean z2;
        Object obj3;
        char current2;
        Object obj4;
        boolean z3;
        Object obj5;
        String str;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + ", " + jSONLexer.info());
        } else {
            ParseContext parseContext2 = this.context;
            try {
                Map<String, Object> innerMap = map instanceof JSONObject ? ((JSONObject) map).getInnerMap() : map;
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
                    if (current3 != '\"') {
                        if (current3 != '}') {
                            if (current3 != '\'') {
                                if (current3 != 26) {
                                    if (current3 != ',') {
                                        if ((current3 >= '0' && current3 <= '9') || current3 == '-') {
                                            jSONLexer.resetStringPosition();
                                            jSONLexer.scanNumber();
                                            try {
                                                Object integerValue = jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(true);
                                                if (jSONLexer.getCurrent() != ':') {
                                                    throw new JSONException("parse number key error" + jSONLexer.info());
                                                }
                                                obj2 = integerValue;
                                                z = false;
                                            } catch (NumberFormatException e) {
                                                throw new JSONException("parse number key error" + jSONLexer.info());
                                            }
                                        } else if (current3 == '{' || current3 == '[') {
                                            jSONLexer.nextToken();
                                            z = true;
                                            obj2 = parse();
                                        } else if (!jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                                            throw new JSONException("syntax error");
                                        } else {
                                            String scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                                            jSONLexer.skipWhitespace();
                                            char current4 = jSONLexer.getCurrent();
                                            str = scanSymbolUnQuoted;
                                            if (current4 != ':') {
                                                throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current4);
                                            }
                                        }
                                        if (!z) {
                                            jSONLexer.next();
                                            jSONLexer.skipWhitespace();
                                        }
                                        current = jSONLexer.getCurrent();
                                        jSONLexer.resetStringPosition();
                                        if (obj2 != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                            String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, '\"');
                                            if (!jSONLexer.isEnabled(Feature.IgnoreAutoType)) {
                                                Class<?> checkAutoType = (map == null || !map.getClass().getName().equals(scanSymbol)) ? this.config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures()) : map.getClass();
                                                if (checkAutoType != null) {
                                                    break;
                                                }
                                                innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol);
                                            } else {
                                                continue;
                                            }
                                        } else if (obj2 != "$ref" && parseContext2 != null && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                            jSONLexer.nextToken(4);
                                            if (jSONLexer.token() == 4) {
                                                String stringVal = jSONLexer.stringVal();
                                                jSONLexer.nextToken(13);
                                                Object obj6 = null;
                                                if (UgcConstant.AT_RULE_TAG.equals(stringVal)) {
                                                    if (this.context != null) {
                                                        ParseContext parseContext3 = this.context;
                                                        Object obj7 = parseContext3.object;
                                                        if ((obj7 instanceof Object[]) || (obj7 instanceof Collection)) {
                                                            obj6 = obj7;
                                                        } else if (parseContext3.parent != null) {
                                                            obj6 = parseContext3.parent.object;
                                                        }
                                                        obj5 = obj6;
                                                    }
                                                    obj5 = null;
                                                } else if (IStringUtil.TOP_PATH.equals(stringVal)) {
                                                    if (parseContext2.object != null) {
                                                        obj5 = parseContext2.object;
                                                    } else {
                                                        addResolveTask(new ResolveTask(parseContext2, stringVal));
                                                        setResolveStatus(1);
                                                        obj5 = null;
                                                    }
                                                } else if ("$".equals(stringVal)) {
                                                    ParseContext parseContext4 = parseContext2;
                                                    while (parseContext4.parent != null) {
                                                        parseContext4 = parseContext4.parent;
                                                    }
                                                    if (parseContext4.object != null) {
                                                        obj6 = parseContext4.object;
                                                    } else {
                                                        addResolveTask(new ResolveTask(parseContext4, stringVal));
                                                        setResolveStatus(1);
                                                    }
                                                    obj5 = obj6;
                                                } else {
                                                    addResolveTask(new ResolveTask(parseContext2, stringVal));
                                                    setResolveStatus(1);
                                                    obj5 = null;
                                                }
                                                if (jSONLexer.token() != 13) {
                                                    throw new JSONException("syntax error");
                                                }
                                                jSONLexer.nextToken(16);
                                                return obj5;
                                            }
                                            throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                                        } else {
                                            if (!z4) {
                                                z2 = z4;
                                            } else if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                                parseContext2 = this.context;
                                                z2 = z4;
                                            } else {
                                                ParseContext context = setContext(map, obj);
                                                if (parseContext2 == null) {
                                                    parseContext2 = context;
                                                }
                                                z2 = true;
                                            }
                                            String str2 = (map.getClass() == JSONObject.class || obj2 != null) ? obj2 : "null";
                                            if (current != '\"') {
                                                jSONLexer.scanString();
                                                String stringVal2 = jSONLexer.stringVal();
                                                String str3 = stringVal2;
                                                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                                    JSONScanner jSONScanner = new JSONScanner(stringVal2);
                                                    Date date = stringVal2;
                                                    if (jSONScanner.scanISO8601DateIfMatch()) {
                                                        date = jSONScanner.getCalendar().getTime();
                                                    }
                                                    jSONScanner.close();
                                                    str3 = date;
                                                }
                                                innerMap.put(str2, str3);
                                                obj3 = str3;
                                            } else if ((current >= '0' && current <= '9') || current == '-') {
                                                jSONLexer.scanNumber();
                                                Number integerValue2 = jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                                                innerMap.put(str2, integerValue2);
                                                obj3 = integerValue2;
                                            } else if (current == '[') {
                                                jSONLexer.nextToken();
                                                Collection jSONArray = new JSONArray();
                                                if (obj == null || obj.getClass() == Integer.class) {
                                                }
                                                if (obj == null) {
                                                    setContext(parseContext2);
                                                }
                                                parseArray(jSONArray, str2);
                                                Object[] objArr = jSONArray;
                                                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                                    objArr = jSONArray.toArray();
                                                }
                                                innerMap.put(str2, objArr);
                                                if (jSONLexer.token() == 13) {
                                                    jSONLexer.nextToken();
                                                    return map;
                                                } else if (jSONLexer.token() != 16) {
                                                    throw new JSONException("syntax error");
                                                } else {
                                                    z4 = z2;
                                                }
                                            } else if (current == '{') {
                                                jSONLexer.nextToken();
                                                boolean z5 = obj != null && obj.getClass() == Integer.class;
                                                Map jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                                                ParseContext context2 = !z5 ? setContext(parseContext2, jSONObject, str2) : null;
                                                if (this.fieldTypeResolver != null) {
                                                    Type resolve = this.fieldTypeResolver.resolve(map, str2 != null ? str2.toString() : null);
                                                    if (resolve != null) {
                                                        obj4 = this.config.getDeserializer(resolve).deserialze(this, resolve, str2);
                                                        z3 = true;
                                                        if (!z3) {
                                                            obj4 = parseObject(jSONObject, str2);
                                                        }
                                                        if (context2 != null && jSONObject != obj4) {
                                                            context2.object = map;
                                                        }
                                                        if (str2 != null) {
                                                            checkMapResolve(map, str2.toString());
                                                        }
                                                        innerMap.put(str2, obj4);
                                                        if (z5) {
                                                            setContext(obj4, str2);
                                                        }
                                                        if (jSONLexer.token() != 13) {
                                                            jSONLexer.nextToken();
                                                            setContext(parseContext2);
                                                            return map;
                                                        } else if (jSONLexer.token() != 16) {
                                                            throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                                        } else {
                                                            if (z5) {
                                                                popContext();
                                                                z4 = z2;
                                                            } else {
                                                                setContext(parseContext2);
                                                                z4 = z2;
                                                            }
                                                        }
                                                    }
                                                }
                                                obj4 = null;
                                                z3 = false;
                                                if (!z3) {
                                                }
                                                if (context2 != null) {
                                                    context2.object = map;
                                                }
                                                if (str2 != null) {
                                                }
                                                innerMap.put(str2, obj4);
                                                if (z5) {
                                                }
                                                if (jSONLexer.token() != 13) {
                                                }
                                            } else {
                                                jSONLexer.nextToken();
                                                innerMap.put(str2, parse());
                                                if (jSONLexer.token() == 13) {
                                                    jSONLexer.nextToken();
                                                    return map;
                                                } else if (jSONLexer.token() != 16) {
                                                    throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + ((Object) str2));
                                                } else {
                                                    z4 = z2;
                                                }
                                            }
                                            jSONLexer.skipWhitespace();
                                            current2 = jSONLexer.getCurrent();
                                            if (current2 == ',') {
                                                if (current2 == '}') {
                                                    jSONLexer.next();
                                                    jSONLexer.resetStringPosition();
                                                    jSONLexer.nextToken();
                                                    setContext(obj3, str2);
                                                    return map;
                                                }
                                                throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + ((Object) str2));
                                            }
                                            jSONLexer.next();
                                            z4 = z2;
                                        }
                                    } else {
                                        throw new JSONException("syntax error");
                                    }
                                } else {
                                    throw new JSONException("syntax error");
                                }
                            } else if (!jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                                throw new JSONException("syntax error");
                            } else {
                                String scanSymbol2 = jSONLexer.scanSymbol(this.symbolTable, '\'');
                                jSONLexer.skipWhitespace();
                                str = scanSymbol2;
                                if (jSONLexer.getCurrent() != ':') {
                                    throw new JSONException("expect ':' at " + jSONLexer.pos());
                                }
                            }
                        } else {
                            jSONLexer.next();
                            jSONLexer.resetStringPosition();
                            jSONLexer.nextToken();
                            if (!z4) {
                                parseContext = (this.context != null && obj == this.context.fieldName && map == this.context.object) ? this.context : setContext(map, obj);
                                setContext(parseContext);
                                return map;
                            }
                            parseContext = parseContext2;
                            setContext(parseContext);
                            return map;
                        }
                    } else {
                        String scanSymbol3 = jSONLexer.scanSymbol(this.symbolTable, '\"');
                        jSONLexer.skipWhitespace();
                        str = scanSymbol3;
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + ((Object) scanSymbol3));
                        }
                    }
                    z = false;
                    obj2 = str;
                    if (!z) {
                    }
                    current = jSONLexer.getCurrent();
                    jSONLexer.resetStringPosition();
                    if (obj2 != JSON.DEFAULT_TYPE_KEY) {
                    }
                    if (obj2 != "$ref") {
                    }
                    if (!z4) {
                    }
                    if (map.getClass() == JSONObject.class) {
                    }
                    if (current != '\"') {
                    }
                    jSONLexer.skipWhitespace();
                    current2 = jSONLexer.getCurrent();
                    if (current2 == ',') {
                    }
                }
            } finally {
                setContext(parseContext2);
            }
        }
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
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
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        Object deserialze;
        String obj2;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i != 14) {
            throw new JSONException("exepct '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
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
                if (this.lexer.token() != 15) {
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            obj2 = parse == null ? null : parse.toString();
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                            deserialze = null;
                        } else {
                            deserialze = deserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(deserialze);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } else {
                    setContext(parseContext);
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                setContext(parseContext);
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        } else if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() != 15) {
                    throw new JSONException("syntax error");
                }
                this.lexer.nextToken(16);
                return new Object[0];
            }
            this.lexer.nextToken(2);
            for (int i = 0; i < typeArr.length; i++) {
                if (this.lexer.token() == 8) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            cast = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type == String.class) {
                        if (this.lexer.token() == 4) {
                            cast = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else {
                        if (i == typeArr.length - 1 && (type instanceof Class)) {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        } else {
                            cls = null;
                            z = false;
                        }
                        if (z && this.lexer.token() != 14) {
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
                            cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i));
                        }
                    }
                }
                objArr[i] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() != 16) {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                } else {
                    if (i == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                }
            }
            if (this.lexer.token() != 15) {
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(16);
            return objArr;
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
                if (!this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                Type type = fieldDeserializer.fieldInfo.fieldType;
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

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
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
                if (bounds.length != 1) {
                    throw new JSONException("not support : " + typeVariable);
                }
                Type type4 = bounds[0];
                if (type4 instanceof Class) {
                    ArrayList arrayList3 = new ArrayList();
                    parseArray((Class) type4, (Collection) arrayList3);
                    return arrayList3;
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

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
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

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
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

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Boolean] */
    public final void parseArray(Collection collection, Object obj) {
        Object[] objArr;
        Number number;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
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
                switch (jSONLexer.token()) {
                    case 2:
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        objArr = integerValue;
                        break;
                    case 3:
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            number = jSONLexer.decimalValue(true);
                        } else {
                            number = jSONLexer.decimalValue(false);
                        }
                        jSONLexer.nextToken(16);
                        objArr = number;
                        break;
                    case 4:
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        objArr = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            objArr = date;
                            break;
                        }
                        break;
                    case 5:
                    case 9:
                    case 10:
                    case 11:
                    case 13:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 22:
                    default:
                        objArr = parse();
                        break;
                    case 6:
                        ?? r0 = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        objArr = r0;
                        break;
                    case 7:
                        ?? r02 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        objArr = r02;
                        break;
                    case 8:
                        jSONLexer.nextToken(4);
                        objArr = null;
                        break;
                    case 12:
                        objArr = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                        break;
                    case 14:
                        Collection jSONArray = new JSONArray();
                        parseArray(jSONArray, Integer.valueOf(i));
                        objArr = jSONArray;
                        if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                            objArr = jSONArray.toArray();
                            break;
                        }
                        break;
                    case 15:
                        jSONLexer.nextToken(16);
                        return;
                    case 20:
                        throw new JSONException("unclosed jsonArray");
                    case 23:
                        jSONLexer.nextToken(4);
                        objArr = null;
                        break;
                }
                collection.add(objArr);
                checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
                i++;
            } finally {
                setContext(parseContext);
            }
        }
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(this.resolveTaskList.size() - 1);
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

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            if (this.contextArrayIndex > 0) {
                this.contextArrayIndex--;
                this.contextArray[this.contextArrayIndex] = null;
            }
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.context = new ParseContext(parseContext, obj, obj2);
        addContext(this.context);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        if (this.contextArray == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= this.contextArray.length) {
            ParseContext[] parseContextArr = new ParseContext[(this.contextArray.length * 3) / 2];
            System.arraycopy(this.contextArray, 0, parseContextArr, 0, this.contextArray.length);
            this.contextArray = parseContextArr;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        switch (jSONLexer.token()) {
            case 2:
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken();
                return integerValue;
            case 3:
                Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                jSONLexer.nextToken();
                return decimalValue;
            case 4:
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    try {
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            return jSONScanner.getCalendar().getTime();
                        }
                        return stringVal;
                    } finally {
                        jSONScanner.close();
                    }
                }
                return stringVal;
            case 5:
            case 10:
            case 11:
            case 13:
            case 15:
            case 16:
            case 17:
            case 19:
            case 24:
            case 25:
            default:
                throw new JSONException("syntax error, " + jSONLexer.info());
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
                if (jSONLexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(10);
                accept(10);
                long longValue = jSONLexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(longValue);
            case 12:
                return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
            case 14:
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                    return jSONArray.toArray();
                }
                return jSONArray;
            case 18:
                if ("NaN".equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    return null;
                }
                throw new JSONException("syntax error, " + jSONLexer.info());
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
            case 26:
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
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

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        for (int i = 0; i < this.contextArray.length && i < this.contextArrayIndex; i++) {
            ParseContext parseContext = this.contextArray[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
        }
        return null;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        if (this.resolveTaskList != null) {
            int size = this.resolveTaskList.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                Object obj3 = null;
                if (resolveTask.ownerContext != null) {
                    obj3 = resolveTask.ownerContext.object;
                }
                if (str.startsWith("$")) {
                    obj2 = getObject(str);
                    if (obj2 == null) {
                        try {
                            obj2 = JSONPath.eval(obj, str);
                        } catch (JSONPathException e) {
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    if (obj2 != null && obj2.getClass() == JSONObject.class && fieldDeserializer.fieldInfo != null && !Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass)) {
                        obj2 = JSONPath.eval(this.contextArray[0].object, str);
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        Type type = null;
        if (this.extraTypeProviders != null) {
            for (ExtraTypeProvider extraTypeProvider : this.extraTypeProviders) {
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
        if (this.extraProcessors != null) {
            for (ExtraProcessor extraProcessor : this.extraProcessors) {
                extraProcessor.processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1709=6] */
    public Object parse(PropertyProcessable propertyProcessable, Object obj) {
        String scanSymbolUnQuoted;
        Object parseObject;
        if (this.lexer.token() != 12) {
            String str = "syntax error, expect {, actual " + this.lexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + this.lexer.info();
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
        int i = 0;
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
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\"');
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
                    if (!this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
                        throw new JSONException("syntax error");
                    }
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\'');
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (!this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    throw new JSONException("syntax error");
                } else {
                    scanSymbolUnQuoted = this.lexer.scanSymbolUnQuoted(this.symbolTable);
                    this.lexer.skipWhitespace();
                    char current2 = this.lexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + current2);
                    }
                }
                String str3 = scanSymbolUnQuoted;
                this.lexer.next();
                this.lexer.skipWhitespace();
                this.lexer.getCurrent();
                this.lexer.resetStringPosition();
                if (str3 != JSON.DEFAULT_TYPE_KEY || this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    this.lexer.nextToken();
                    if (i != 0) {
                        setContext(parseContext);
                    }
                    Type type = propertyProcessable.getType(str3);
                    if (this.lexer.token() == 8) {
                        parseObject = null;
                        this.lexer.nextToken();
                    } else {
                        parseObject = parseObject(type, str3);
                    }
                    propertyProcessable.apply(str3, parseObject);
                    setContext(parseContext, parseObject, str3);
                    setContext(parseContext);
                    int i2 = this.lexer.token();
                    if (i2 == 20 || i2 == 15) {
                        break;
                    } else if (i2 == 13) {
                        this.lexer.nextToken();
                        return propertyProcessable;
                    }
                } else {
                    Class<?> checkAutoType = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, '\"'), null, this.lexer.getFeatures());
                    if (!Map.class.isAssignableFrom(checkAutoType)) {
                        ObjectDeserializer deserializer = this.config.getDeserializer(checkAutoType);
                        this.lexer.nextToken(16);
                        setResolveStatus(2);
                        if (parseContext != null && !(obj instanceof Integer)) {
                            popContext();
                        }
                        return (Map) deserializer.deserialze(this, checkAutoType, obj);
                    }
                    this.lexer.nextToken(16);
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return propertyProcessable;
                    }
                }
                i++;
            } finally {
                setContext(parseContext);
            }
        }
        return propertyProcessable;
    }
}
