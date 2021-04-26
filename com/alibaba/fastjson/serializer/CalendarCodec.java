package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ObjectDeserializer, ContextObjectSerializer {
    public static final CalendarCodec instance = new CalendarCodec();
    public DatatypeFactory dateFactory;

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        if (this.dateFactory == null) {
            try {
                this.dateFactory = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e2) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e2);
            }
        }
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
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

    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i2) {
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

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Calendar calendar;
        char[] charArray;
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
            char c2 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : Typography.quote;
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
