package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
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
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/* loaded from: classes.dex */
public class JodaCodec implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final DateTimeFormatter ISO_FIXED_FORMAT;
    public static final DateTimeFormatter defaultFormatter;
    public static final DateTimeFormatter defaultFormatter_23;
    public static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter formatter_d10_cn;
    public static final DateTimeFormatter formatter_d10_de;
    public static final DateTimeFormatter formatter_d10_eur;
    public static final DateTimeFormatter formatter_d10_in;
    public static final DateTimeFormatter formatter_d10_kr;
    public static final DateTimeFormatter formatter_d10_tw;
    public static final DateTimeFormatter formatter_d10_us;
    public static final DateTimeFormatter formatter_d8;
    public static final DateTimeFormatter formatter_dt19_cn;
    public static final DateTimeFormatter formatter_dt19_cn_1;
    public static final DateTimeFormatter formatter_dt19_de;
    public static final DateTimeFormatter formatter_dt19_eur;
    public static final DateTimeFormatter formatter_dt19_in;
    public static final DateTimeFormatter formatter_dt19_kr;
    public static final DateTimeFormatter formatter_dt19_tw;
    public static final DateTimeFormatter formatter_dt19_us;
    public static final DateTimeFormatter formatter_iso8601;
    public static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final JodaCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1222805734, "Lcom/alibaba/fastjson/serializer/JodaCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1222805734, "Lcom/alibaba/fastjson/serializer/JodaCodec;");
                return;
            }
        }
        instance = new JodaCodec();
        defaultFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        defaultFormatter_23 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
        formatter_dt19_tw = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
        formatter_dt19_cn = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");
        formatter_dt19_cn_1 = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");
        formatter_dt19_kr = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");
        formatter_dt19_us = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        formatter_dt19_eur = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        formatter_dt19_de = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");
        formatter_dt19_in = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
        formatter_d8 = DateTimeFormat.forPattern("yyyyMMdd");
        formatter_d10_tw = DateTimeFormat.forPattern("yyyy/MM/dd");
        formatter_d10_cn = DateTimeFormat.forPattern("yyyy年M月d日");
        formatter_d10_kr = DateTimeFormat.forPattern("yyyy년M월d일");
        formatter_d10_us = DateTimeFormat.forPattern("MM/dd/yyyy");
        formatter_d10_eur = DateTimeFormat.forPattern("dd/MM/yyyy");
        formatter_d10_de = DateTimeFormat.forPattern("dd.MM.yyyy");
        formatter_d10_in = DateTimeFormat.forPattern("dd-MM-yyyy");
        ISO_FIXED_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.getDefault());
        formatter_iso8601 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
    }

    public JodaCodec() {
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) ? (T) deserialze(defaultJSONParser, type, obj, null, 0) : (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime parseDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        InterceptResult invokeLL;
        DateTimeFormatter dateTimeFormatter2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, dateTimeFormatter)) == null) {
            if (dateTimeFormatter == null) {
                boolean z = false;
                if (str.length() == 19) {
                    char charAt = str.charAt(4);
                    char charAt2 = str.charAt(7);
                    char charAt3 = str.charAt(10);
                    char charAt4 = str.charAt(13);
                    char charAt5 = str.charAt(16);
                    if (charAt4 == ':' && charAt5 == ':') {
                        if (charAt != '-' || charAt2 != '-') {
                            if (charAt == '/' && charAt2 == '/') {
                                dateTimeFormatter2 = formatter_dt19_tw;
                            } else {
                                char charAt6 = str.charAt(0);
                                char charAt7 = str.charAt(1);
                                char charAt8 = str.charAt(2);
                                char charAt9 = str.charAt(3);
                                char charAt10 = str.charAt(5);
                                if (charAt8 == '/' && charAt10 == '/') {
                                    int i3 = ((charAt9 - '0') * 10) + (charAt - '0');
                                    if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                        dateTimeFormatter2 = formatter_dt19_eur;
                                    } else if (i3 > 12) {
                                        dateTimeFormatter2 = formatter_dt19_us;
                                    } else {
                                        String country = Locale.getDefault().getCountry();
                                        if (country.equals("US")) {
                                            dateTimeFormatter2 = formatter_dt19_us;
                                        } else if (country.equals("BR") || country.equals("AU")) {
                                            dateTimeFormatter2 = formatter_dt19_eur;
                                        }
                                    }
                                } else if (charAt8 == '.' && charAt10 == '.') {
                                    dateTimeFormatter2 = formatter_dt19_de;
                                } else if (charAt8 == '-' && charAt10 == '-') {
                                    dateTimeFormatter2 = formatter_dt19_in;
                                }
                            }
                            if (str.length() >= 17) {
                                char charAt11 = str.charAt(4);
                                if (charAt11 == 24180) {
                                    if (str.charAt(str.length() - 1) == 31186) {
                                        dateTimeFormatter2 = formatter_dt19_cn_1;
                                    } else {
                                        dateTimeFormatter2 = formatter_dt19_cn;
                                    }
                                } else if (charAt11 == 45380) {
                                    dateTimeFormatter2 = formatter_dt19_kr;
                                }
                            }
                            i2 = 0;
                            while (true) {
                                if (i2 >= str.length()) {
                                    z = true;
                                    break;
                                }
                                char charAt12 = str.charAt(i2);
                                if (charAt12 < '0' || charAt12 > '9') {
                                    break;
                                }
                                i2++;
                            }
                            if (z && str.length() > 8 && str.length() < 19) {
                                return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(JSON.defaultTimeZone));
                            }
                        } else {
                            if (charAt3 == 'T') {
                                dateTimeFormatter2 = formatter_iso8601;
                            } else if (charAt3 == ' ') {
                                dateTimeFormatter2 = defaultFormatter;
                            }
                            if (str.length() >= 17) {
                            }
                            i2 = 0;
                            while (true) {
                                if (i2 >= str.length()) {
                                }
                                i2++;
                            }
                            if (z) {
                                return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(JSON.defaultTimeZone));
                            }
                        }
                    }
                    dateTimeFormatter2 = dateTimeFormatter;
                    if (str.length() >= 17) {
                    }
                    i2 = 0;
                    while (true) {
                        if (i2 >= str.length()) {
                        }
                        i2++;
                    }
                    if (z) {
                    }
                } else {
                    if (str.length() == 23) {
                        char charAt13 = str.charAt(4);
                        char charAt14 = str.charAt(7);
                        char charAt15 = str.charAt(10);
                        char charAt16 = str.charAt(13);
                        char charAt17 = str.charAt(16);
                        char charAt18 = str.charAt(19);
                        if (charAt16 == ':' && charAt17 == ':' && charAt13 == '-' && charAt14 == '-' && charAt15 == ' ' && charAt18 == '.') {
                            dateTimeFormatter2 = defaultFormatter_23;
                            if (str.length() >= 17) {
                            }
                            i2 = 0;
                            while (true) {
                                if (i2 >= str.length()) {
                                }
                                i2++;
                            }
                            if (z) {
                            }
                        }
                    }
                    dateTimeFormatter2 = dateTimeFormatter;
                    if (str.length() >= 17) {
                    }
                    i2 = 0;
                    while (true) {
                        if (i2 >= str.length()) {
                        }
                        i2++;
                    }
                    if (z) {
                    }
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (dateTimeFormatter2 == null) {
                return LocalDateTime.parse(str);
            }
            return LocalDateTime.parse(str, dateTimeFormatter2);
        }
        return (LocalDateTime) invokeLL.objValue;
    }

    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        InterceptResult invokeLLL;
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, dateTimeFormatter)) == null) {
            if (dateTimeFormatter == null) {
                if (str.length() == 8) {
                    dateTimeFormatter = formatter_d8;
                }
                boolean z = false;
                if (str.length() == 10) {
                    char charAt = str.charAt(4);
                    char charAt2 = str.charAt(7);
                    if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_d10_tw;
                    }
                    char charAt3 = str.charAt(0);
                    char charAt4 = str.charAt(1);
                    char charAt5 = str.charAt(2);
                    char charAt6 = str.charAt(3);
                    char charAt7 = str.charAt(5);
                    if (charAt5 == '/' && charAt7 == '/') {
                        int i2 = ((charAt6 - '0') * 10) + (charAt - '0');
                        if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        } else if (i2 > 12) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter3 = formatter_d10_us;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter3 = formatter_d10_eur;
                            }
                        }
                        dateTimeFormatter = dateTimeFormatter3;
                    } else if (charAt5 == '.' && charAt7 == '.') {
                        dateTimeFormatter = formatter_d10_de;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        dateTimeFormatter = formatter_d10_in;
                    }
                }
                if (str.length() >= 9) {
                    char charAt8 = str.charAt(4);
                    if (charAt8 == 24180) {
                        dateTimeFormatter2 = formatter_d10_cn;
                    } else if (charAt8 == 45380) {
                        dateTimeFormatter2 = formatter_d10_kr;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= str.length()) {
                        z = true;
                        break;
                    }
                    char charAt9 = str.charAt(i3);
                    if (charAt9 < '0' || charAt9 > '9') {
                        break;
                    }
                    i3++;
                }
                if (z && str.length() > 8 && str.length() < 19) {
                    return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(JSON.defaultTimeZone)).toLocalDate();
                }
            }
            if (dateTimeFormatter == null) {
                return LocalDate.parse(str);
            }
            return LocalDate.parse(str, dateTimeFormatter);
        }
        return (LocalDate) invokeLLL.objValue;
    }

    public DateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, dateTimeFormatter)) == null) {
            if (dateTimeFormatter == null) {
                if (str.length() == 19) {
                    char charAt = str.charAt(4);
                    char charAt2 = str.charAt(7);
                    char charAt3 = str.charAt(10);
                    char charAt4 = str.charAt(13);
                    char charAt5 = str.charAt(16);
                    if (charAt4 == ':' && charAt5 == ':') {
                        if (charAt == '-' && charAt2 == '-') {
                            if (charAt3 == 'T') {
                                dateTimeFormatter = formatter_iso8601;
                            } else if (charAt3 == ' ') {
                                dateTimeFormatter = defaultFormatter;
                            }
                        } else if (charAt == '/' && charAt2 == '/') {
                            dateTimeFormatter = formatter_dt19_tw;
                        } else {
                            char charAt6 = str.charAt(0);
                            char charAt7 = str.charAt(1);
                            char charAt8 = str.charAt(2);
                            char charAt9 = str.charAt(3);
                            char charAt10 = str.charAt(5);
                            if (charAt8 == '/' && charAt10 == '/') {
                                int i2 = ((charAt9 - '0') * 10) + (charAt - '0');
                                if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                } else if (i2 > 12) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else {
                                    String country = Locale.getDefault().getCountry();
                                    if (country.equals("US")) {
                                        dateTimeFormatter = formatter_dt19_us;
                                    } else if (country.equals("BR") || country.equals("AU")) {
                                        dateTimeFormatter = formatter_dt19_eur;
                                    }
                                }
                            } else if (charAt8 == '.' && charAt10 == '.') {
                                dateTimeFormatter = formatter_dt19_de;
                            } else if (charAt8 == '-' && charAt10 == '-') {
                                dateTimeFormatter = formatter_dt19_in;
                            }
                        }
                    }
                }
                if (str.length() >= 17) {
                    char charAt11 = str.charAt(4);
                    if (charAt11 == 24180) {
                        if (str.charAt(str.length() - 1) == 31186) {
                            dateTimeFormatter = formatter_dt19_cn_1;
                        } else {
                            dateTimeFormatter = formatter_dt19_cn;
                        }
                    } else if (charAt11 == 45380) {
                        dateTimeFormatter = formatter_dt19_kr;
                    }
                }
            }
            if (dateTimeFormatter == null) {
                return DateTime.parse(str);
            }
            return DateTime.parse(str, dateTimeFormatter);
        }
        return (DateTime) invokeLL.objValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull();
                return;
            }
            if (type == null) {
                type = obj.getClass();
            }
            if (type == LocalDateTime.class) {
                int mask = SerializerFeature.UseISO8601DateFormat.getMask();
                LocalDateTime localDateTime = (LocalDateTime) obj;
                String dateFormatPattern = jSONSerializer.getDateFormatPattern();
                if (dateFormatPattern == null) {
                    if ((mask & i2) != 0 || jSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
                        dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss";
                    } else if (jSONSerializer.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                        dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
                    } else {
                        dateFormatPattern = localDateTime.getMillisOfSecond() == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
                    }
                }
                if (dateFormatPattern != null) {
                    write(serializeWriter, (ReadablePartial) localDateTime, dateFormatPattern);
                    return;
                } else {
                    serializeWriter.writeLong(localDateTime.toDateTime(DateTimeZone.forTimeZone(JSON.defaultTimeZone)).toInstant().getMillis());
                    return;
                }
            }
            serializeWriter.writeString(obj.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [T, org.joda.time.LocalDateTime] */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i2) {
        InterceptResult invokeCommon;
        DateTimeFormatter dateTimeFormatter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{defaultJSONParser, type, obj, str, Integer.valueOf(i2)})) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 8) {
                jSONLexer.nextToken();
                return null;
            } else if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken();
                if (str == null) {
                    dateTimeFormatter = null;
                } else if ("yyyy-MM-dd HH:mm:ss".equals(str)) {
                    dateTimeFormatter = defaultFormatter;
                } else {
                    dateTimeFormatter = DateTimeFormat.forPattern(str);
                }
                if ("".equals(stringVal)) {
                    return null;
                }
                if (type == LocalDateTime.class) {
                    if (stringVal.length() != 10 && stringVal.length() != 8) {
                        return (T) parseDateTime(stringVal, dateTimeFormatter);
                    }
                    return (T) parseLocalDate(stringVal, str, dateTimeFormatter).toLocalDateTime(LocalTime.MIDNIGHT);
                } else if (type == LocalDate.class) {
                    if (stringVal.length() == 23) {
                        return (T) LocalDateTime.parse(stringVal).toLocalDate();
                    }
                    return (T) parseLocalDate(stringVal, str, dateTimeFormatter);
                } else if (type == LocalTime.class) {
                    if (stringVal.length() == 23) {
                        return (T) LocalDateTime.parse(stringVal).toLocalTime();
                    }
                    return (T) LocalTime.parse(stringVal);
                } else if (type == DateTime.class) {
                    if (dateTimeFormatter == defaultFormatter) {
                        dateTimeFormatter = ISO_FIXED_FORMAT;
                    }
                    return (T) parseZonedDateTime(stringVal, dateTimeFormatter);
                } else if (type == DateTimeZone.class) {
                    return (T) DateTimeZone.forID(stringVal);
                } else {
                    if (type == Period.class) {
                        return (T) Period.parse(stringVal);
                    }
                    if (type == Duration.class) {
                        return (T) Duration.parse(stringVal);
                    }
                    if (type == Instant.class) {
                        boolean z = false;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= stringVal.length()) {
                                z = true;
                                break;
                            }
                            char charAt = stringVal.charAt(i3);
                            if (charAt < '0' || charAt > '9') {
                                break;
                            }
                            i3++;
                        }
                        if (z && stringVal.length() > 8 && stringVal.length() < 19) {
                            return (T) new Instant(Long.parseLong(stringVal));
                        }
                        return (T) Instant.parse(stringVal);
                    } else if (type == DateTimeFormatter.class) {
                        return (T) DateTimeFormat.forPattern(stringVal);
                    } else {
                        return null;
                    }
                }
            } else if (jSONLexer.token() == 2) {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                TimeZone timeZone = JSON.defaultTimeZone;
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (type == DateTime.class) {
                    return (T) new DateTime(longValue, DateTimeZone.forTimeZone(timeZone));
                }
                ?? r9 = (T) new LocalDateTime(longValue, DateTimeZone.forTimeZone(timeZone));
                if (type == LocalDateTime.class) {
                    return r9;
                }
                if (type == LocalDate.class) {
                    return (T) r9.toLocalDate();
                }
                if (type == LocalTime.class) {
                    return (T) r9.toLocalTime();
                }
                if (type == Instant.class) {
                    return (T) new Instant(longValue);
                }
                throw new UnsupportedOperationException();
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, jSONSerializer, obj, beanContext) == null) {
            write(jSONSerializer.out, (ReadablePartial) obj, beanContext.getFormat());
        }
    }

    private void write(SerializeWriter serializeWriter, ReadablePartial readablePartial, String str) {
        DateTimeFormatter forPattern;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, serializeWriter, readablePartial, str) == null) {
            if (str.equals("yyyy-MM-dd'T'HH:mm:ss")) {
                forPattern = formatter_iso8601;
            } else {
                forPattern = DateTimeFormat.forPattern(str);
            }
            serializeWriter.writeString(forPattern.print(readablePartial));
        }
    }
}
