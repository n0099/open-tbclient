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
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final BigDecimal HIGH;
    public static final BigDecimal LOW;
    public static final BigDecimalCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(572856341, "Lcom/alibaba/fastjson/serializer/BigDecimalCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(572856341, "Lcom/alibaba/fastjson/serializer/BigDecimalCodec;");
                return;
            }
        }
        LOW = BigDecimal.valueOf(-9007199254740991L);
        HIGH = BigDecimal.valueOf(9007199254740991L);
        instance = new BigDecimalCodec();
    }

    public BigDecimalCodec() {
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
                throw new JSONException("parseDecimal error, field : " + obj, e2);
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
        String bigDecimal;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
                return;
            }
            BigDecimal bigDecimal2 = (BigDecimal) obj;
            int scale = bigDecimal2.scale();
            if (SerializerFeature.isEnabled(i2, serializeWriter.features, SerializerFeature.WriteBigDecimalAsPlain) && scale >= -100 && scale < 100) {
                bigDecimal = bigDecimal2.toPlainString();
            } else {
                bigDecimal = bigDecimal2.toString();
            }
            if (scale == 0 && bigDecimal.length() >= 16 && SerializerFeature.isEnabled(i2, serializeWriter.features, SerializerFeature.BrowserCompatible) && (bigDecimal2.compareTo(LOW) < 0 || bigDecimal2.compareTo(HIGH) > 0)) {
                serializeWriter.writeString(bigDecimal);
                return;
            }
            serializeWriter.write(bigDecimal);
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal2.scale() == 0) {
                serializeWriter.write(46);
            }
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 2) {
                T t = (T) jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return t;
            } else if (jSONLexer.token() == 3) {
                T t2 = (T) jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return t2;
            } else {
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                return (T) TypeUtils.castToBigDecimal(parse);
            }
        }
        return (T) invokeL.objValue;
    }
}
