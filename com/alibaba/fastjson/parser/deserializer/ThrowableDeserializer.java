package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ParserConfig) objArr2[0], (Class) objArr2[1], (Type) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        InterceptResult invokeLLL;
        Constructor<?>[] constructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, th, cls)) == null) {
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
        return (Throwable) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f0, code lost:
        if (r14 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f2, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fe, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0100, code lost:
        r15 = (T) createException(r5, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0104, code lost:
        if (r15 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0106, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010b, code lost:
        if (r6 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010d, code lost:
        ((java.lang.Throwable) r15).setStackTrace(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0110, code lost:
        if (r0 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0112, code lost:
        if (r14 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0116, code lost:
        if (r14 != r12.clazz) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0118, code lost:
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x011a, code lost:
        r13 = r13.getConfig().getDeserializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0124, code lost:
        if ((r13 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0126, code lost:
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0129, code lost:
        if (r2 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012b, code lost:
        r13 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0137, code lost:
        if (r13.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0139, code lost:
        r14 = (java.util.Map.Entry) r13.next();
        r14 = r14.getValue();
        r0 = r2.getFieldDeserializer((java.lang.String) r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014d, code lost:
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014f, code lost:
        r0.setValue(r15, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0153, code lost:
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0154, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x015c, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0177, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r14.getName());
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) != null) {
            return (T) invokeLLL.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }
}
