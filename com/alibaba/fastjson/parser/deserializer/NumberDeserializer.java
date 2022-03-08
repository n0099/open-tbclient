package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final NumberDeserializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559553227, "Lcom/alibaba/fastjson/parser/deserializer/NumberDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559553227, "Lcom/alibaba/fastjson/parser/deserializer/NumberDeserializer;");
                return;
            }
        }
        instance = new NumberDeserializer();
    }

    public NumberDeserializer() {
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

    /* JADX WARN: Type inference failed for: r9v24, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 2) {
                if (type != Double.TYPE && type != Double.class) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(16);
                    if (type == Short.TYPE || type == Short.class) {
                        if (longValue <= 32767 && longValue >= -32768) {
                            return (T) Short.valueOf((short) longValue);
                        }
                        throw new JSONException("short overflow : " + longValue);
                    } else if (type != Byte.TYPE && type != Byte.class) {
                        if (longValue >= -2147483648L && longValue <= 2147483647L) {
                            return (T) Integer.valueOf((int) longValue);
                        }
                        return (T) Long.valueOf(longValue);
                    } else if (longValue <= 127 && longValue >= -128) {
                        return (T) Byte.valueOf((byte) longValue);
                    } else {
                        throw new JSONException("short overflow : " + longValue);
                    }
                }
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            } else if (jSONLexer.token() == 3) {
                if (type != Double.TYPE && type != Double.class) {
                    if (type != Short.TYPE && type != Short.class) {
                        if (type != Byte.TYPE && type != Byte.class) {
                            ?? r9 = (T) jSONLexer.decimalValue();
                            jSONLexer.nextToken(16);
                            return jSONLexer.isEnabled(Feature.UseBigDecimal) ? r9 : (T) Double.valueOf(r9.doubleValue());
                        }
                        BigDecimal decimalValue = jSONLexer.decimalValue();
                        jSONLexer.nextToken(16);
                        return (T) Byte.valueOf(TypeUtils.byteValue(decimalValue));
                    }
                    BigDecimal decimalValue2 = jSONLexer.decimalValue();
                    jSONLexer.nextToken(16);
                    return (T) Short.valueOf(TypeUtils.shortValue(decimalValue2));
                }
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString2));
            } else if (jSONLexer.token() == 18 && WalletPayViewController.DEF_CHANNEL_TITLE.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (type == Double.class) {
                    return (T) Double.valueOf(Double.NaN);
                }
                if (type == Float.class) {
                    return (T) Float.valueOf(Float.NaN);
                }
                return null;
            } else {
                Object parse = defaultJSONParser.parse();
                if (parse == null) {
                    return null;
                }
                if (type != Double.TYPE && type != Double.class) {
                    if (type != Short.TYPE && type != Short.class) {
                        if (type != Byte.TYPE && type != Byte.class) {
                            return (T) TypeUtils.castToBigDecimal(parse);
                        }
                        try {
                            return (T) TypeUtils.castToByte(parse);
                        } catch (Exception e2) {
                            throw new JSONException("parseByte error, field : " + obj, e2);
                        }
                    }
                    try {
                        return (T) TypeUtils.castToShort(parse);
                    } catch (Exception e3) {
                        throw new JSONException("parseShort error, field : " + obj, e3);
                    }
                }
                try {
                    return (T) TypeUtils.castToDouble(parse);
                } catch (Exception e4) {
                    throw new JSONException("parseDouble error, field : " + obj, e4);
                }
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
}
