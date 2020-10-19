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
/* loaded from: classes5.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        return (T) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r12) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r5 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2 = new java.lang.Exception(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r1 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r2.setStackTrace(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r3 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
        if (r5 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (r5 != r10.clazz) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
        r3 = r3.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
        if (r3.hasNext() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        r0 = (java.util.Map.Entry) r3.next();
        r0 = r0.getValue();
        r1 = r10.getFieldDeserializer((java.lang.String) r0.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r1 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
        r1.setValue(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017a, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r5) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0199, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r5.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019a, code lost:
        r0 = createException(r4, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x019e, code lost:
        if (r0 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a0, code lost:
        r0 = new java.lang.Exception(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a5, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b1, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b2, code lost:
        r0 = r11.getConfig().getDeserializer(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01bc, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01be, code lost:
        r10 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c6, code lost:
        r10 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer] */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        Throwable th;
        Class<?> cls2;
        String str;
        HashMap hashMap;
        StackTraceElement[] stackTraceElementArr;
        HashMap hashMap2;
        String str2;
        Class<?> cls3;
        Throwable th2;
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
        Throwable th3 = null;
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        String str3 = null;
        StackTraceElement[] stackTraceElementArr2 = null;
        HashMap hashMap3 = null;
        Class<?> cls4 = cls;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (scanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    th = th3;
                    cls2 = cls4;
                    str = str3;
                    hashMap = hashMap3;
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
                    th2 = th3;
                    StackTraceElement[] stackTraceElementArr3 = stackTraceElementArr2;
                    str2 = str3;
                    cls3 = checkAutoType;
                    hashMap2 = hashMap3;
                    stackTraceElementArr = stackTraceElementArr3;
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
                cls3 = cls4;
                th2 = th3;
                String str4 = stringVal;
                hashMap2 = hashMap3;
                stackTraceElementArr = stackTraceElementArr2;
                str2 = str4;
            } else if ("cause".equals(scanSymbol)) {
                HashMap hashMap4 = hashMap3;
                stackTraceElementArr = stackTraceElementArr2;
                str2 = str3;
                cls3 = cls4;
                th2 = (Throwable) deserialze(defaultJSONParser, null, "cause");
                hashMap2 = hashMap4;
            } else if ("stackTrace".equals(scanSymbol)) {
                str2 = str3;
                cls3 = cls4;
                th2 = th3;
                hashMap2 = hashMap3;
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
            } else {
                hashMap2 = hashMap3 == null ? new HashMap() : hashMap3;
                hashMap2.put(scanSymbol, defaultJSONParser.parse());
                stackTraceElementArr = stackTraceElementArr2;
                str2 = str3;
                cls3 = cls4;
                th2 = th3;
            }
            if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                cls2 = cls3;
                th = th2;
                hashMap = hashMap2;
                str = str2;
                break;
            }
            th3 = th2;
            cls4 = cls3;
            str3 = str2;
            stackTraceElementArr2 = stackTraceElementArr;
            hashMap3 = hashMap2;
        }
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        Constructor<?>[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i = 0;
        Constructor<?> constructor4 = null;
        while (i < length) {
            Constructor<?> constructor5 = constructors[i];
            Class<?>[] parameterTypes = constructor5.getParameterTypes();
            if (parameterTypes.length == 0) {
                Constructor<?> constructor6 = constructor3;
                constructor = constructor5;
                constructor5 = constructor6;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor = constructor2;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor4 = constructor5;
                constructor5 = constructor3;
                constructor = constructor2;
            } else {
                constructor5 = constructor3;
                constructor = constructor2;
            }
            i++;
            constructor2 = constructor;
            constructor3 = constructor5;
        }
        if (constructor4 != null) {
            return (Throwable) constructor4.newInstance(str, th);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(str);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[0]);
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
