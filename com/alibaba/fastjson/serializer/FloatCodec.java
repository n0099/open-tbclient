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
import java.text.DecimalFormat;
import java.text.NumberFormat;
/* loaded from: classes.dex */
public class FloatCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static FloatCodec instance;
    public transient /* synthetic */ FieldHolder $fh;
    public NumberFormat decimalFormat;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-679022238, "Lcom/alibaba/fastjson/serializer/FloatCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-679022238, "Lcom/alibaba/fastjson/serializer/FloatCodec;");
                return;
            }
        }
        instance = new FloatCodec();
    }

    public FloatCodec() {
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
            try {
                return (T) deserialze(defaultJSONParser);
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
            float floatValue = ((Float) obj).floatValue();
            NumberFormat numberFormat = this.decimalFormat;
            if (numberFormat != null) {
                serializeWriter.write(numberFormat.format(floatValue));
            } else {
                serializeWriter.writeFloat(floatValue, true);
            }
        }
    }

    public FloatCodec(DecimalFormat decimalFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decimalFormat};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.decimalFormat = decimalFormat;
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 2) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString));
            } else if (jSONLexer.token() == 3) {
                float floatValue = jSONLexer.floatValue();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(floatValue);
            } else {
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                return (T) TypeUtils.castToFloat(parse);
            }
        }
        return (T) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatCodec(String str) {
        this(new DecimalFormat(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((DecimalFormat) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
