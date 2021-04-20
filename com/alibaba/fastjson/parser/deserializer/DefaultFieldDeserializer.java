package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    public boolean customDeserilizer;
    public ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        boolean z = false;
        this.customDeserilizer = false;
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            Class<?> deserializeUsing = annotation.deserializeUsing();
            if (deserializeUsing != null && deserializeUsing != Void.class) {
                z = true;
            }
            this.customDeserilizer = z;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.deserializeUsing() != Void.class) {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e2) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e2);
                }
            } else {
                FieldInfo fieldInfo = this.fieldInfo;
                this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        byte[] deserialze;
        FieldInfo fieldInfo;
        int i;
        if (this.fieldValueDeserilizer == null) {
            getFieldValueDeserilizer(defaultJSONParser.getConfig());
        }
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        Type type2 = this.fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            ParseContext context = defaultJSONParser.getContext();
            if (context != null) {
                context.type = type;
            }
            if (type2 != type) {
                type2 = FieldInfo.getFieldType(this.clazz, type, type2);
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
            }
        }
        Type type3 = type2;
        if ((objectDeserializer instanceof JavaBeanDeserializer) && (i = (fieldInfo = this.fieldInfo).parserFeatures) != 0) {
            deserialze = ((JavaBeanDeserializer) objectDeserializer).deserialze(defaultJSONParser, type3, fieldInfo.name, i);
        } else {
            FieldInfo fieldInfo2 = this.fieldInfo;
            if ((fieldInfo2.format != null || fieldInfo2.parserFeatures != 0) && (objectDeserializer instanceof ContextObjectDeserializer)) {
                FieldInfo fieldInfo3 = this.fieldInfo;
                deserialze = ((ContextObjectDeserializer) objectDeserializer).deserialze(defaultJSONParser, type3, fieldInfo3.name, fieldInfo3.format, fieldInfo3.parserFeatures);
            } else {
                deserialze = objectDeserializer.deserialze(defaultJSONParser, type3, this.fieldInfo.name);
            }
        }
        if ((deserialze instanceof byte[]) && (AsyncHttpClient.ENCODING_GZIP.equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) deserialze));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                deserialze = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new JSONException("unzip bytes error.", e2);
            }
        }
        if (defaultJSONParser.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser.getContext();
            defaultJSONParser.setResolveStatus(0);
        } else if (obj == null) {
            map.put(this.fieldInfo.name, deserialze);
        } else {
            setValue(obj, deserialze);
        }
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }
}
