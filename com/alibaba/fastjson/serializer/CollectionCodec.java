package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
/* loaded from: classes9.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final CollectionCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(316437186, "Lcom/alibaba/fastjson/serializer/CollectionCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(316437186, "Lcom/alibaba/fastjson/serializer/CollectionCodec;");
                return;
            }
        }
        instance = new CollectionCodec();
    }

    public CollectionCodec() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.alibaba.fastjson.parser.DefaultJSONParser */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.alibaba.fastjson.JSONArray, T, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            if (defaultJSONParser.lexer.token() == 8) {
                defaultJSONParser.lexer.nextToken(16);
                return null;
            } else if (type == JSONArray.class) {
                ?? r6 = (T) new JSONArray();
                defaultJSONParser.parseArray((Collection) r6);
                return r6;
            } else {
                ?? r0 = (T) TypeUtils.createCollection(type);
                defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), r0, obj);
                return r0;
            }
        }
        return (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 14;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
                return;
            }
            Type type2 = null;
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) || SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                type2 = TypeUtils.getCollectionItemType(type);
            }
            Collection collection = (Collection) obj;
            SerialContext serialContext = jSONSerializer.context;
            int i3 = 0;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                if (HashSet.class.isAssignableFrom(collection.getClass())) {
                    serializeWriter.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    serializeWriter.append((CharSequence) "TreeSet");
                }
            }
            try {
                serializeWriter.append('[');
                for (Object obj3 : collection) {
                    int i4 = i3 + 1;
                    if (i3 != 0) {
                        serializeWriter.append(',');
                    }
                    if (obj3 == null) {
                        serializeWriter.writeNull();
                    } else {
                        Class<?> cls = obj3.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj3).intValue());
                        } else if (cls == Long.class) {
                            serializeWriter.writeLong(((Long) obj3).longValue());
                            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                                serializeWriter.write(76);
                            }
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(cls);
                            if (SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName) && (objectWriter instanceof JavaBeanSerializer)) {
                                ((JavaBeanSerializer) objectWriter).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i4 - 1), type2, i2);
                            } else {
                                objectWriter.write(jSONSerializer, obj3, Integer.valueOf(i4 - 1), type2, i2);
                            }
                        }
                    }
                    i3 = i4;
                }
                serializeWriter.append(']');
            } finally {
                jSONSerializer.context = serialContext;
            }
        }
    }
}
