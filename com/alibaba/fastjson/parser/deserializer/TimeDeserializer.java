package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
/* loaded from: classes3.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeDeserializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-371060815, "Lcom/alibaba/fastjson/parser/deserializer/TimeDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-371060815, "Lcom/alibaba/fastjson/parser/deserializer/TimeDeserializer;");
                return;
            }
        }
        instance = new TimeDeserializer();
    }

    public TimeDeserializer() {
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
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
                if (jSONLexer.token() == 4) {
                    jSONLexer.nextTokenWithColon(2);
                    if (jSONLexer.token() == 2) {
                        long longValue = jSONLexer.longValue();
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken(16);
                            return (T) new Time(longValue);
                        }
                        throw new JSONException("syntax error");
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            T t = (T) defaultJSONParser.parse();
            if (t == null) {
                return null;
            }
            if (t instanceof Time) {
                return t;
            }
            if (t instanceof BigDecimal) {
                return (T) new Time(TypeUtils.longValue((BigDecimal) t));
            }
            if (t instanceof Number) {
                return (T) new Time(((Number) t).longValue());
            }
            if (t instanceof String) {
                String str = (String) t;
                if (str.length() == 0) {
                    return null;
                }
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch()) {
                    parseLong = jSONScanner.getCalendar().getTimeInMillis();
                } else {
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= str.length()) {
                            z = true;
                            break;
                        }
                        char charAt = str.charAt(i2);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        jSONScanner.close();
                        return (T) Time.valueOf(str);
                    }
                    parseLong = Long.parseLong(str);
                }
                jSONScanner.close();
                return (T) new Time(parseLong);
            }
            throw new JSONException("parse error");
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
