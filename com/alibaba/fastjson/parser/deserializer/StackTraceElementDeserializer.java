package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final StackTraceElementDeserializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1525717133, "Lcom/alibaba/fastjson/parser/deserializer/StackTraceElementDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1525717133, "Lcom/alibaba/fastjson/parser/deserializer/StackTraceElementDeserializer;");
                return;
            }
        }
        instance = new StackTraceElementDeserializer();
    }

    public StackTraceElementDeserializer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x01d7, code lost:
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) != null) {
            return (T) invokeLLL.objValue;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error: " + JSONToken.name(jSONLexer.token()));
        } else {
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
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
                if (PushClientConstants.TAG_CLASS_NAME.equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str = null;
                    } else if (jSONLexer.token() == 4) {
                        str = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("methodName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str2 = null;
                    } else if (jSONLexer.token() == 4) {
                        str2 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("fileName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str3 = null;
                    } else if (jSONLexer.token() == 4) {
                        str3 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("lineNumber".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        i2 = 0;
                    } else if (jSONLexer.token() == 2) {
                        i2 = jSONLexer.intValue();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("nativeMethod".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 6) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 7) {
                        jSONLexer.nextToken(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (scanSymbol == JSON.DEFAULT_TYPE_KEY) {
                    if (jSONLexer.token() == 4) {
                        String stringVal = jSONLexer.stringVal();
                        if (!stringVal.equals("java.lang.StackTraceElement")) {
                            throw new JSONException("syntax error : " + stringVal);
                        }
                    } else if (jSONLexer.token() != 8) {
                        throw new JSONException("syntax error");
                    }
                } else if ("moduleName".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else if ("moduleVersion".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else if ("classLoaderName".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else {
                    throw new JSONException("syntax error : " + scanSymbol);
                }
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }
}
