package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes7.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean customDeserilizer;
    public ObjectDeserializer fieldValueDeserilizer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, cls, fieldInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Class) objArr2[0], (FieldInfo) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
            if (objectDeserializer != null) {
                return objectDeserializer.getFastMatchToken();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parserConfig)) == null) {
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
        return (ObjectDeserializer) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        byte[] deserialze;
        FieldInfo fieldInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, defaultJSONParser, obj, type, map) == null) {
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
            if ((objectDeserializer instanceof JavaBeanDeserializer) && (i2 = (fieldInfo = this.fieldInfo).parserFeatures) != 0) {
                deserialze = ((JavaBeanDeserializer) objectDeserializer).deserialze(defaultJSONParser, type3, fieldInfo.name, i2);
            } else {
                FieldInfo fieldInfo2 = this.fieldInfo;
                if ((fieldInfo2.format != null || fieldInfo2.parserFeatures != 0) && (objectDeserializer instanceof ContextObjectDeserializer)) {
                    FieldInfo fieldInfo3 = this.fieldInfo;
                    deserialze = ((ContextObjectDeserializer) objectDeserializer).deserialze(defaultJSONParser, type3, fieldInfo3.name, fieldInfo3.format, fieldInfo3.parserFeatures);
                } else {
                    deserialze = objectDeserializer.deserialze(defaultJSONParser, type3, this.fieldInfo.name);
                }
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
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, defaultJSONParser, obj, type, map) == null) {
            throw new JSONException("TODO");
        }
    }
}
