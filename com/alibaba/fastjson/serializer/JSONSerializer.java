package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class JSONSerializer extends SerializeFilterable {
    public final SerializeConfig config;
    public SerialContext context;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public String fastJsonConfigDateFormatPattern;
    public String indent;
    public int indentCount;
    public Locale locale;
    public final SerializeWriter out;
    public IdentityHashMap<Object, SerialContext> references;
    public TimeZone timeZone;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    private DateFormat generateDateFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.locale);
        simpleDateFormat.setTimeZone(this.timeZone);
        return simpleDateFormat;
    }

    public static void write(Writer writer, Object obj) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            try {
                new JSONSerializer(serializeWriter).write(obj);
                serializeWriter.writeTo(writer);
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        } finally {
            serializeWriter.close();
        }
    }

    public boolean checkValue(SerializeFilterable serializeFilterable) {
        List<ContextValueFilter> list;
        List<ValueFilter> list2;
        List<ContextValueFilter> list3;
        List<ValueFilter> list4 = this.valueFilters;
        return (list4 != null && list4.size() > 0) || ((list = this.contextValueFilters) != null && list.size() > 0) || (((list2 = serializeFilterable.valueFilters) != null && list2.size() > 0) || (((list3 = serializeFilterable.contextValueFilters) != null && list3.size() > 0) || this.out.writeNonStringValueAsString));
    }

    public void close() {
        this.out.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public boolean containsReference(Object obj) {
        SerialContext serialContext;
        IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
        if (identityHashMap == null || (serialContext = identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = serialContext.fieldName;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public DateFormat getDateFormat() {
        String str;
        if (this.dateFormat == null && (str = this.dateFormatPattern) != null) {
            this.dateFormat = generateDateFormat(str);
        }
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat dateFormat = this.dateFormat;
        if (dateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateFormat).toPattern();
        }
        return this.dateFormatPattern;
    }

    public String getFastJsonConfigDateFormatPattern() {
        return this.fastJsonConfigDateFormatPattern;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return this.config.getObjectWriter(cls);
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public boolean hasNameFilters(SerializeFilterable serializeFilterable) {
        List<NameFilter> list;
        List<NameFilter> list2 = this.nameFilters;
        return (list2 != null && list2.size() > 0) || ((list = serializeFilterable.nameFilters) != null && list.size() > 0);
    }

    public boolean hasPropertyFilters(SerializeFilterable serializeFilterable) {
        List<PropertyFilter> list;
        List<PropertyFilter> list2 = this.propertyFilters;
        return (list2 != null && list2.size() > 0) || ((list = serializeFilterable.propertyFilters) != null && list.size() > 0);
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return this.out.isEnabled(serializerFeature);
    }

    public final boolean isWriteClassName(Type type, Object obj) {
        SerialContext serialContext;
        return this.out.isEnabled(SerializerFeature.WriteClassName) && !(type == null && this.out.isEnabled(SerializerFeature.NotWriteRootClassName) && ((serialContext = this.context) == null || serialContext.parent == null));
    }

    public void popContext() {
        SerialContext serialContext = this.context;
        if (serialContext != null) {
            this.context = serialContext.parent;
        }
    }

    public void println() {
        this.out.write(10);
        for (int i2 = 0; i2 < this.indentCount; i2++) {
            this.out.write(this.indent);
        }
    }

    public void setContext(SerialContext serialContext) {
        this.context = serialContext;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public void setFastJsonConfigDateFormatPattern(String str) {
        this.fastJsonConfigDateFormatPattern = str;
    }

    public String toString() {
        return this.out.toString();
    }

    public final void writeAs(Object obj, Class cls) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(cls).write(this, obj, null, null, 0);
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public final void writeKeyValue(char c2, String str, Object obj) {
        if (c2 != 0) {
            this.out.write(c2);
        }
        this.out.writeFieldName(str);
        write(obj);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public void writeReference(Object obj) {
        SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext serialContext2 = serialContext.parent;
        if (serialContext2 != null && obj == serialContext2.object) {
            this.out.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            SerialContext serialContext3 = serialContext.parent;
            if (serialContext3 == null) {
                break;
            }
            serialContext = serialContext3;
        }
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        this.out.write("{\"$ref\":\"");
        this.out.write(this.references.get(obj).toString());
        this.out.write("\"}");
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        writeWithFieldName(obj, obj2, null, 0);
    }

    public final void writeWithFormat(Object obj, String str) {
        GZIPOutputStream gZIPOutputStream;
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.out.writeInt((int) (((Date) obj).getTime() / 1000));
            } else if ("millis".equals(str)) {
                this.out.writeLong(((Date) obj).getTime());
            } else {
                DateFormat dateFormat = getDateFormat();
                if (dateFormat == null) {
                    if (str != null) {
                        try {
                            dateFormat = generateDateFormat(str);
                        } catch (IllegalArgumentException unused) {
                            dateFormat = generateDateFormat(str.replaceAll("T", "'T'"));
                        }
                    } else {
                        String str2 = this.fastJsonConfigDateFormatPattern;
                        if (str2 != null) {
                            dateFormat = generateDateFormat(str2);
                        } else {
                            dateFormat = generateDateFormat(JSON.DEFFAULT_DATE_FORMAT);
                        }
                    }
                }
                this.out.writeString(dateFormat.format((Date) obj));
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (!AsyncHttpClient.ENCODING_GZIP.equals(str) && !"gzip,base64".equals(str)) {
                if ("hex".equals(str)) {
                    this.out.writeHex(bArr);
                    return;
                } else {
                    this.out.writeByteArray(bArr);
                    return;
                }
            }
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (bArr.length < 512) {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                    } else {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    }
                    gZIPOutputStream2 = gZIPOutputStream;
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    this.out.writeByteArray(byteArrayOutputStream.toByteArray());
                } finally {
                    IOUtils.close(gZIPOutputStream2);
                }
            } catch (IOException e2) {
                throw new JSONException("write gzipBytes error", e2);
            }
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.out.write(91);
            for (int i2 = 0; i2 < collection.size(); i2++) {
                Object next = it.next();
                if (i2 != 0) {
                    this.out.write(44);
                }
                writeWithFormat(next, str);
            }
            this.out.write(93);
        } else {
            write(obj);
        }
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.getGlobalInstance());
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i2) {
        setContext(serialContext, obj, obj2, i2, 0);
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i2) {
        try {
            if (obj == null) {
                this.out.writeNull();
            } else {
                getObjectWriter(obj.getClass()).write(this, obj, obj2, type, i2);
            }
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter(), serializeConfig);
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i2, int i3) {
        if (this.out.disableCircularReferenceDetect) {
            return;
        }
        this.context = new SerialContext(serialContext, obj, obj2, i2, i3);
        if (this.references == null) {
            this.references = new IdentityHashMap<>();
        }
        this.references.put(obj, this.context);
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.indentCount = 0;
        this.indent = TrackUI.SEPERATOR;
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setContext(Object obj, Object obj2) {
        setContext(this.context, obj, obj2, 0);
    }

    public static void write(SerializeWriter serializeWriter, Object obj) {
        new JSONSerializer(serializeWriter).write(obj);
    }

    public final void write(Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(obj.getClass()).write(this, obj, null, null, 0);
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public final void write(String str) {
        StringCodec.instance.write(this, str);
    }
}
