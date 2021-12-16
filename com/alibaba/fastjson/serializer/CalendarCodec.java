package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ObjectDeserializer, ContextObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static final CalendarCodec instance;
    public transient /* synthetic */ FieldHolder $fh;
    public DatatypeFactory dateFactory;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-674225374, "Lcom/alibaba/fastjson/serializer/CalendarCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-674225374, "Lcom/alibaba/fastjson/serializer/CalendarCodec;");
                return;
            }
        }
        instance = new CalendarCodec();
    }

    public CalendarCodec() {
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

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, calendar)) == null) {
            if (this.dateFactory == null) {
                try {
                    this.dateFactory = DatatypeFactory.newInstance();
                } catch (DatatypeConfigurationException e2) {
                    throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e2);
                }
            }
            return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
        }
        return (XMLGregorianCalendar) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, defaultJSONParser, type, obj)) == null) ? (T) deserialze(defaultJSONParser, type, obj, null, 0) : (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, jSONSerializer, obj, beanContext) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            String format = beanContext.getFormat();
            Calendar calendar = (Calendar) obj;
            if (format.equals("unixtime")) {
                serializeWriter.writeInt((int) (calendar.getTimeInMillis() / 1000));
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
            serializeWriter.writeString(simpleDateFormat.format(calendar.getTime()));
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{defaultJSONParser, type, obj, str, Integer.valueOf(i2)})) == null) {
            T t = (T) DateCodec.instance.deserialze(defaultJSONParser, type, obj, str, i2);
            if (t instanceof Calendar) {
                return t;
            }
            Date date = (Date) t;
            if (date == null) {
                return null;
            }
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            ?? r7 = (T) Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
            r7.setTime(date);
            return type == XMLGregorianCalendar.class ? (T) createXMLGregorianCalendar((GregorianCalendar) r7) : r7;
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Calendar calendar;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull();
                return;
            }
            if (obj instanceof XMLGregorianCalendar) {
                calendar = ((XMLGregorianCalendar) obj).toGregorianCalendar();
            } else {
                calendar = (Calendar) obj;
            }
            if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
                char c2 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? ExtendedMessageFormat.QUOTE : '\"';
                serializeWriter.append(c2);
                int i3 = calendar.get(1);
                int i4 = calendar.get(2) + 1;
                int i5 = calendar.get(5);
                int i6 = calendar.get(11);
                int i7 = calendar.get(12);
                int i8 = calendar.get(13);
                int i9 = calendar.get(14);
                if (i9 != 0) {
                    charArray = "0000-00-00T00:00:00.000".toCharArray();
                    IOUtils.getChars(i9, 23, charArray);
                    IOUtils.getChars(i8, 19, charArray);
                    IOUtils.getChars(i7, 16, charArray);
                    IOUtils.getChars(i6, 13, charArray);
                    IOUtils.getChars(i5, 10, charArray);
                    IOUtils.getChars(i4, 7, charArray);
                    IOUtils.getChars(i3, 4, charArray);
                } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                    charArray = "0000-00-00".toCharArray();
                    IOUtils.getChars(i5, 10, charArray);
                    IOUtils.getChars(i4, 7, charArray);
                    IOUtils.getChars(i3, 4, charArray);
                } else {
                    charArray = "0000-00-00T00:00:00".toCharArray();
                    IOUtils.getChars(i8, 19, charArray);
                    IOUtils.getChars(i7, 16, charArray);
                    IOUtils.getChars(i6, 13, charArray);
                    IOUtils.getChars(i5, 10, charArray);
                    IOUtils.getChars(i4, 7, charArray);
                    IOUtils.getChars(i3, 4, charArray);
                }
                serializeWriter.write(charArray);
                float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
                int i10 = (int) offset;
                if (i10 == 0.0d) {
                    serializeWriter.write(90);
                } else {
                    if (i10 > 9) {
                        serializeWriter.write(43);
                        serializeWriter.writeInt(i10);
                    } else if (i10 > 0) {
                        serializeWriter.write(43);
                        serializeWriter.write(48);
                        serializeWriter.writeInt(i10);
                    } else if (i10 < -9) {
                        serializeWriter.write(45);
                        serializeWriter.writeInt(i10);
                    } else if (i10 < 0) {
                        serializeWriter.write(45);
                        serializeWriter.write(48);
                        serializeWriter.writeInt(-i10);
                    }
                    serializeWriter.write(58);
                    serializeWriter.append((CharSequence) String.format("%02d", Integer.valueOf((int) ((offset - i10) * 60.0f))));
                }
                serializeWriter.append(c2);
                return;
            }
            jSONSerializer.write(calendar.getTime());
        }
    }
}
