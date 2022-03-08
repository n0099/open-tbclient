package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes3.dex */
public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static StringCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1512089973, "Lcom/alibaba/fastjson/serializer/StringCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1512089973, "Lcom/alibaba/fastjson/serializer/StringCodec;");
                return;
            }
        }
        instance = new StringCodec();
    }

    public StringCodec() {
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

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            if (type == StringBuffer.class) {
                JSONLexer jSONLexer = defaultJSONParser.lexer;
                if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextToken(16);
                    return (T) new StringBuffer(stringVal);
                }
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                return (T) new StringBuffer(parse.toString());
            } else if (type == StringBuilder.class) {
                JSONLexer jSONLexer2 = defaultJSONParser.lexer;
                if (jSONLexer2.token() == 4) {
                    String stringVal2 = jSONLexer2.stringVal();
                    jSONLexer2.nextToken(16);
                    return (T) new StringBuilder(stringVal2);
                }
                Object parse2 = defaultJSONParser.parse();
                if (parse2 == null) {
                    return null;
                }
                return (T) new StringBuilder(parse2.toString());
            } else {
                return (T) deserialze(defaultJSONParser);
            }
        }
        return (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, (String) obj);
        }
    }

    public void write(JSONSerializer jSONSerializer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONSerializer, str) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (str == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullStringAsEmpty);
            } else {
                serializeWriter.writeString(str);
            }
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, defaultJSONParser)) == null) {
            JSONLexer lexer = defaultJSONParser.getLexer();
            if (lexer.token() == 4) {
                T t = (T) lexer.stringVal();
                lexer.nextToken(16);
                return t;
            } else if (lexer.token() == 2) {
                T t2 = (T) lexer.numberString();
                lexer.nextToken(16);
                return t2;
            } else {
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                return (T) parse.toString();
            }
        }
        return (T) invokeL.objValue;
    }
}
