package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
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
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
/* loaded from: classes3.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static OptionalCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-722028945, "Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-722028945, "Lcom/alibaba/fastjson/parser/deserializer/OptionalCodec;");
                return;
            }
        }
        instance = new OptionalCodec();
    }

    public OptionalCodec() {
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
            if (type == OptionalInt.class) {
                Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class<Object>) Integer.class));
                if (castToInt == null) {
                    return (T) OptionalInt.empty();
                }
                return (T) OptionalInt.of(castToInt.intValue());
            } else if (type == OptionalLong.class) {
                Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class<Object>) Long.class));
                if (castToLong == null) {
                    return (T) OptionalLong.empty();
                }
                return (T) OptionalLong.of(castToLong.longValue());
            } else if (type == OptionalDouble.class) {
                Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class<Object>) Double.class));
                if (castToDouble == null) {
                    return (T) OptionalDouble.empty();
                }
                return (T) OptionalDouble.of(castToDouble.doubleValue());
            } else {
                Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
                if (parseObject == null) {
                    return (T) Optional.empty();
                }
                return (T) Optional.of(parseObject);
            }
        }
        return (T) invokeLLL.objValue;
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

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            if (obj == null) {
                jSONSerializer.writeNull();
            } else if (obj instanceof Optional) {
                Optional optional = (Optional) obj;
                jSONSerializer.write(optional.isPresent() ? optional.get() : null);
            } else if (obj instanceof OptionalDouble) {
                OptionalDouble optionalDouble = (OptionalDouble) obj;
                if (optionalDouble.isPresent()) {
                    jSONSerializer.write(Double.valueOf(optionalDouble.getAsDouble()));
                } else {
                    jSONSerializer.writeNull();
                }
            } else if (obj instanceof OptionalInt) {
                OptionalInt optionalInt = (OptionalInt) obj;
                if (optionalInt.isPresent()) {
                    jSONSerializer.out.writeInt(optionalInt.getAsInt());
                } else {
                    jSONSerializer.writeNull();
                }
            } else if (obj instanceof OptionalLong) {
                OptionalLong optionalLong = (OptionalLong) obj;
                if (optionalLong.isPresent()) {
                    jSONSerializer.out.writeLong(optionalLong.getAsLong());
                } else {
                    jSONSerializer.writeNull();
                }
            } else {
                throw new JSONException("not support optional : " + obj.getClass());
            }
        }
    }
}
