package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
/* loaded from: classes3.dex */
public class SqlDateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final SqlDateDeserializer instance;
    public static final SqlDateDeserializer instance_timestamp;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean timestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-430592746, "Lcom/alibaba/fastjson/parser/deserializer/SqlDateDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-430592746, "Lcom/alibaba/fastjson/parser/deserializer/SqlDateDeserializer;");
                return;
            }
        }
        instance = new SqlDateDeserializer();
        instance_timestamp = new SqlDateDeserializer(true);
    }

    public SqlDateDeserializer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.timestamp = false;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        InterceptResult invokeLLLL;
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, defaultJSONParser, type, obj, obj2)) == null) {
            if (this.timestamp) {
                return (T) castTimestamp(defaultJSONParser, type, obj, obj2);
            }
            if (obj2 == null) {
                return null;
            }
            if (obj2 instanceof Date) {
                return (T) new java.sql.Date(((Date) obj2).getTime());
            }
            if (obj2 instanceof BigDecimal) {
                return (T) new java.sql.Date(TypeUtils.longValue((BigDecimal) obj2));
            }
            if (obj2 instanceof Number) {
                return (T) new java.sql.Date(((Number) obj2).longValue());
            }
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (str.length() == 0) {
                    return null;
                }
                JSONScanner jSONScanner = new JSONScanner(str);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        parseLong = jSONScanner.getCalendar().getTimeInMillis();
                    } else {
                        try {
                            return (T) new java.sql.Date(defaultJSONParser.getDateFormat().parse(str).getTime());
                        } catch (ParseException unused) {
                            parseLong = Long.parseLong(str);
                        }
                    }
                    jSONScanner.close();
                    return (T) new java.sql.Date(parseLong);
                } finally {
                    jSONScanner.close();
                }
            }
            throw new JSONException("parse error : " + obj2);
        }
        return (T) invokeLLLL.objValue;
    }

    public <T> T castTimestamp(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        InterceptResult invokeLLLL;
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, defaultJSONParser, type, obj, obj2)) == null) {
            if (obj2 == null) {
                return null;
            }
            if (obj2 instanceof Date) {
                return (T) new Timestamp(((Date) obj2).getTime());
            }
            if (obj2 instanceof BigDecimal) {
                return (T) new Timestamp(TypeUtils.longValue((BigDecimal) obj2));
            }
            if (obj2 instanceof Number) {
                return (T) new Timestamp(((Number) obj2).longValue());
            }
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (str.length() == 0) {
                    return null;
                }
                JSONScanner jSONScanner = new JSONScanner(str);
                try {
                    if (str.length() > 19 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                        String dateFomartPattern = defaultJSONParser.getDateFomartPattern();
                        if (dateFomartPattern.length() != str.length() && dateFomartPattern == JSON.DEFFAULT_DATE_FORMAT) {
                            return (T) Timestamp.valueOf(str);
                        }
                    }
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        parseLong = jSONScanner.getCalendar().getTimeInMillis();
                    } else {
                        try {
                            return (T) new Timestamp(defaultJSONParser.getDateFormat().parse(str).getTime());
                        } catch (ParseException unused) {
                            parseLong = Long.parseLong(str);
                        }
                    }
                    jSONScanner.close();
                    return (T) new Timestamp(parseLong);
                } finally {
                    jSONScanner.close();
                }
            }
            throw new JSONException("parse error");
        }
        return (T) invokeLLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public SqlDateDeserializer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.timestamp = false;
        this.timestamp = true;
    }
}
