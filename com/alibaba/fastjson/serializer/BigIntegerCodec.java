package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
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
import java.math.BigInteger;
/* loaded from: classes7.dex */
public class BigIntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final BigInteger HIGH;
    public static final BigInteger LOW;
    public static final BigIntegerCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2058575806, "Lcom/alibaba/fastjson/serializer/BigIntegerCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2058575806, "Lcom/alibaba/fastjson/serializer/BigIntegerCodec;");
                return;
            }
        }
        LOW = BigInteger.valueOf(-9007199254740991L);
        HIGH = BigInteger.valueOf(9007199254740991L);
        instance = new BigIntegerCodec();
    }

    public BigIntegerCodec() {
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) ? (T) deserialze(defaultJSONParser) : (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
                return;
            }
            BigInteger bigInteger = (BigInteger) obj;
            String bigInteger2 = bigInteger.toString();
            if (bigInteger2.length() >= 16 && SerializerFeature.isEnabled(i2, serializeWriter.features, SerializerFeature.BrowserCompatible) && (bigInteger.compareTo(LOW) < 0 || bigInteger.compareTo(HIGH) > 0)) {
                serializeWriter.writeString(bigInteger2);
            } else {
                serializeWriter.write(bigInteger2);
            }
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 2) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                if (numberString.length() <= 65535) {
                    return (T) new BigInteger(numberString);
                }
                throw new JSONException("decimal overflow");
            }
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (T) TypeUtils.castToBigInteger(parse);
        }
        return (T) invokeL.objValue;
    }
}
