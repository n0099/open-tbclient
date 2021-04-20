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
/* loaded from: classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?>[] constructors;
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ec, code lost:
        if (r14 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ee, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fa, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
        r15 = (T) createException(r5, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0100, code lost:
        if (r15 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0102, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0107, code lost:
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0109, code lost:
        ((java.lang.Throwable) r15).setStackTrace(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010c, code lost:
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010e, code lost:
        if (r14 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0112, code lost:
        if (r14 != r12.clazz) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0114, code lost:
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0116, code lost:
        r13 = r13.getConfig().getDeserializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0120, code lost:
        if ((r13 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0122, code lost:
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0125, code lost:
        if (r2 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0127, code lost:
        r13 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0133, code lost:
        if (r13.hasNext() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0135, code lost:
        r14 = (java.util.Map.Entry) r13.next();
        r14 = r14.getValue();
        r0 = r2.getFieldDeserializer((java.lang.String) r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0149, code lost:
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014b, code lost:
        r0.setValue(r15, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014f, code lost:
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0150, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0158, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0173, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r14.getName());
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        JavaBeanDeserializer javaBeanDeserializer = null;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
        } else if (jSONLexer.token() != 12) {
            throw new JSONException("syntax error");
        }
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        HashMap hashMap = null;
        Throwable th = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (scanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                } else if (jSONLexer.token() == 16 && jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            jSONLexer.nextTokenWithColon(4);
            if (JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token() == 4) {
                    cls = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), Throwable.class, jSONLexer.getFeatures());
                    jSONLexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    str = null;
                } else if (jSONLexer.token() == 4) {
                    str = jSONLexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
            } else if ("cause".equals(scanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, null, "cause");
            } else if ("stackTrace".equals(scanSymbol)) {
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
            } else {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(scanSymbol, defaultJSONParser.parse());
            }
            if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                break;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
