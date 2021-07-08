package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((SerializeWriter) objArr[0], (SerializeConfig) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private DateFormat generateDateFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.locale);
            simpleDateFormat.setTimeZone(this.timeZone);
            return simpleDateFormat;
        }
        return (DateFormat) invokeL.objValue;
    }

    public static void write(Writer writer, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, writer, obj) == null) {
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
    }

    public boolean checkValue(SerializeFilterable serializeFilterable) {
        InterceptResult invokeL;
        List<ContextValueFilter> list;
        List<ValueFilter> list2;
        List<ContextValueFilter> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, serializeFilterable)) == null) {
            List<ValueFilter> list4 = this.valueFilters;
            return (list4 != null && list4.size() > 0) || ((list = this.contextValueFilters) != null && list.size() > 0) || (((list2 = serializeFilterable.valueFilters) != null && list2.size() > 0) || (((list3 = serializeFilterable.contextValueFilters) != null && list3.size() > 0) || this.out.writeNonStringValueAsString));
        }
        return invokeL.booleanValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.out.close();
        }
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, serializerFeature, z) == null) {
            this.out.config(serializerFeature, z);
        }
    }

    public boolean containsReference(Object obj) {
        InterceptResult invokeL;
        SerialContext serialContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
            if (identityHashMap == null || (serialContext = identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
                return false;
            }
            Object obj2 = serialContext.fieldName;
            return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
        }
        return invokeL.booleanValue;
    }

    public void decrementIdent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.indentCount--;
        }
    }

    public SerialContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.context : (SerialContext) invokeV.objValue;
    }

    public DateFormat getDateFormat() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.dateFormat == null && (str = this.dateFormatPattern) != null) {
                this.dateFormat = generateDateFormat(str);
            }
            return this.dateFormat;
        }
        return (DateFormat) invokeV.objValue;
    }

    public String getDateFormatPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            DateFormat dateFormat = this.dateFormat;
            if (dateFormat instanceof SimpleDateFormat) {
                return ((SimpleDateFormat) dateFormat).toPattern();
            }
            return this.dateFormatPattern;
        }
        return (String) invokeV.objValue;
    }

    public String getFastJsonConfigDateFormatPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.fastJsonConfigDateFormatPattern : (String) invokeV.objValue;
    }

    public int getIndentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.indentCount : invokeV.intValue;
    }

    public SerializeConfig getMapping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.config : (SerializeConfig) invokeV.objValue;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cls)) == null) ? this.config.getObjectWriter(cls) : (ObjectSerializer) invokeL.objValue;
    }

    public SerializeWriter getWriter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.out : (SerializeWriter) invokeV.objValue;
    }

    public boolean hasNameFilters(SerializeFilterable serializeFilterable) {
        InterceptResult invokeL;
        List<NameFilter> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, serializeFilterable)) == null) {
            List<NameFilter> list2 = this.nameFilters;
            return (list2 != null && list2.size() > 0) || ((list = serializeFilterable.nameFilters) != null && list.size() > 0);
        }
        return invokeL.booleanValue;
    }

    public boolean hasPropertyFilters(SerializeFilterable serializeFilterable) {
        InterceptResult invokeL;
        List<PropertyFilter> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, serializeFilterable)) == null) {
            List<PropertyFilter> list2 = this.propertyFilters;
            return (list2 != null && list2.size() > 0) || ((list = serializeFilterable.propertyFilters) != null && list.size() > 0);
        }
        return invokeL.booleanValue;
    }

    public void incrementIndent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.indentCount++;
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, serializerFeature)) == null) ? this.out.isEnabled(serializerFeature) : invokeL.booleanValue;
    }

    public final boolean isWriteClassName(Type type, Object obj) {
        InterceptResult invokeLL;
        SerialContext serialContext;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, type, obj)) == null) ? this.out.isEnabled(SerializerFeature.WriteClassName) && !(type == null && this.out.isEnabled(SerializerFeature.NotWriteRootClassName) && ((serialContext = this.context) == null || serialContext.parent == null)) : invokeLL.booleanValue;
    }

    public void popContext() {
        SerialContext serialContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (serialContext = this.context) == null) {
            return;
        }
        this.context = serialContext.parent;
    }

    public void println() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.out.write(10);
            for (int i2 = 0; i2 < this.indentCount; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    public void setContext(SerialContext serialContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, serialContext) == null) {
            this.context = serialContext;
        }
    }

    public void setDateFormat(DateFormat dateFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dateFormat) == null) {
            this.dateFormat = dateFormat;
            if (this.dateFormatPattern != null) {
                this.dateFormatPattern = null;
            }
        }
    }

    public void setFastJsonConfigDateFormatPattern(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.fastJsonConfigDateFormatPattern = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.out.toString() : (String) invokeV.objValue;
    }

    public final void writeAs(Object obj, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, obj, cls) == null) {
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
    }

    public final void writeKeyValue(char c2, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Character.valueOf(c2), str, obj}) == null) {
            if (c2 != 0) {
                this.out.write(c2);
            }
            this.out.writeFieldName(str);
            write(obj);
        }
    }

    public void writeNull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.out.writeNull();
        }
    }

    public void writeReference(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, obj) == null) {
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
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, obj, obj2) == null) {
            writeWithFieldName(obj, obj2, null, 0);
        }
    }

    public final void writeWithFormat(Object obj, String str) {
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, obj, str) == null) {
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
                    } catch (IOException e2) {
                        throw new JSONException("write gzipBytes error", e2);
                    }
                } finally {
                    IOUtils.close(gZIPOutputStream2);
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.getGlobalInstance());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serializeWriter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SerializeWriter) objArr2[0], (SerializeConfig) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048597, this, serialContext, obj, obj2, i2) == null) {
            setContext(serialContext, obj, obj2, i2, 0);
        }
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048611, this, obj, obj2, type, i2) == null) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter(), serializeConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serializeConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SerializeWriter) objArr2[0], (SerializeConfig) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{serialContext, obj, obj2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || this.out.disableCircularReferenceDetect) {
            return;
        }
        this.context = new SerialContext(serialContext, obj, obj2, i2, i3);
        if (this.references == null) {
            this.references = new IdentityHashMap<>();
        }
        this.references.put(obj, this.context);
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serializeWriter, serializeConfig};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.indentCount = 0;
        this.indent = TrackUI.SEPERATOR;
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.dateFormatPattern = str;
            if (this.dateFormat != null) {
                this.dateFormat = null;
            }
        }
    }

    public void setContext(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, obj, obj2) == null) {
            setContext(this.context, obj, obj2, 0);
        }
    }

    public static void write(SerializeWriter serializeWriter, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, serializeWriter, obj) == null) {
            new JSONSerializer(serializeWriter).write(obj);
        }
    }

    public final void write(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, obj) == null) {
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
    }

    public final void write(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            StringCodec.instance.write(this, str);
        }
    }
}
