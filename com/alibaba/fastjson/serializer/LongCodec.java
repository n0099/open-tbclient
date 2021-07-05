package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class LongCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static LongCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2108067680, "Lcom/alibaba/fastjson/serializer/LongCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2108067680, "Lcom/alibaba/fastjson/serializer/LongCodec;");
                return;
            }
        }
        instance = new LongCodec();
    }

    public LongCodec() {
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
        Object castToLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            try {
                int i2 = jSONLexer.token();
                if (i2 == 2) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(16);
                    castToLong = (T) Long.valueOf(longValue);
                } else if (i2 == 3) {
                    castToLong = (T) Long.valueOf(TypeUtils.longValue(jSONLexer.decimalValue()));
                    jSONLexer.nextToken(16);
                } else {
                    if (i2 == 12) {
                        JSONObject jSONObject = new JSONObject(true);
                        defaultJSONParser.parseObject((Map) jSONObject);
                        castToLong = (T) TypeUtils.castToLong(jSONObject);
                    } else {
                        castToLong = TypeUtils.castToLong(defaultJSONParser.parse());
                    }
                    if (castToLong == null) {
                        return null;
                    }
                }
                return type == AtomicLong.class ? (T) new AtomicLong(((Long) castToLong).longValue()) : (T) castToLong;
            } catch (Exception e2) {
                throw new JSONException("parseLong error, field : " + obj, e2);
            }
        }
        return (T) invokeLLL.objValue;
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
            long longValue = ((Long) obj).longValue();
            serializeWriter.writeLong(longValue);
            if (!serializeWriter.isEnabled(SerializerFeature.WriteClassName) || longValue > 2147483647L || longValue < -2147483648L || type == Long.class || type == Long.TYPE) {
                return;
            }
            serializeWriter.write(76);
        }
    }
}
