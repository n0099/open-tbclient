package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
        return (T) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r11) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r4 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        r2 = new java.lang.Exception(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        r2.setStackTrace(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        if (r6 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        if (r4 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
        if (r4 != r9.clazz) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        r3 = r6.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (r3.hasNext() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        r0 = (java.util.Map.Entry) r3.next();
        r0 = r0.getValue();
        r1 = r9.getFieldDeserializer((java.lang.String) r0.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (r1 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
        r1.setValue(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0156, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r4) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0175, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r4.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0176, code lost:
        r0 = createException(r3, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017a, code lost:
        if (r0 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017c, code lost:
        r0 = new java.lang.Exception(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0181, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0184, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018d, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018e, code lost:
        r0 = r10.getConfig().getDeserializer(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019a, code lost:
        r9 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a2, code lost:
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer] */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        StackTraceElement[] stackTraceElementArr;
        HashMap hashMap;
        String stringVal;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
        } else if (jSONLexer.token() != 12) {
            throw new JSONException("syntax error");
        }
        Throwable th = null;
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr2 = null;
        HashMap hashMap2 = null;
        Class<?> cls2 = cls;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (scanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    hashMap = hashMap2;
                    stackTraceElementArr = stackTraceElementArr2;
                    break;
                } else if (jSONLexer.token() == 16 && jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            jSONLexer.nextTokenWithColon(4);
            if (JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token() == 4) {
                    Class<?> checkAutoType = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), Throwable.class, jSONLexer.getFeatures());
                    jSONLexer.nextToken(16);
                    cls2 = checkAutoType;
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    stringVal = null;
                } else if (jSONLexer.token() == 4) {
                    stringVal = jSONLexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
                str = stringVal;
            } else if ("cause".equals(scanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, null, "cause");
            } else if ("stackTrace".equals(scanSymbol)) {
                stackTraceElementArr2 = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
            } else {
                HashMap hashMap3 = hashMap2 == null ? new HashMap() : hashMap2;
                hashMap3.put(scanSymbol, defaultJSONParser.parse());
                hashMap2 = hashMap3;
            }
            if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                hashMap = hashMap2;
                stackTraceElementArr = stackTraceElementArr2;
                break;
            }
        }
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?>[] constructors;
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor3 = constructor4;
            }
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[0]);
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
