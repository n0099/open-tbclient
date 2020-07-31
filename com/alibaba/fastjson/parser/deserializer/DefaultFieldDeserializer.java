package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes3.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.deserializeUsing() != Void.class) {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            } else {
                this.fieldValueDeserilizer = parserConfig.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        byte[] deserialze;
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
        if ((objectDeserializer instanceof JavaBeanDeserializer) && this.fieldInfo.parserFeatures != 0) {
            deserialze = ((JavaBeanDeserializer) objectDeserializer).deserialze(defaultJSONParser, type2, this.fieldInfo.name, this.fieldInfo.parserFeatures);
        } else if (this.fieldInfo.format != null && (objectDeserializer instanceof ContextObjectDeserializer)) {
            deserialze = ((ContextObjectDeserializer) objectDeserializer).deserialze(defaultJSONParser, type2, this.fieldInfo.name, this.fieldInfo.format, this.fieldInfo.parserFeatures);
        } else {
            deserialze = objectDeserializer.deserialze(defaultJSONParser, type2, this.fieldInfo.name);
        }
        if ((deserialze instanceof byte[]) && ("gzip".equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
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
            } catch (IOException e) {
                throw new JSONException("unzip bytes error.", e);
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

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        if (this.fieldValueDeserilizer != null) {
            return this.fieldValueDeserilizer.getFastMatchToken();
        }
        return 2;
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }
}
