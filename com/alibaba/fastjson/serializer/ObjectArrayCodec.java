package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
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
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes6.dex */
public class ObjectArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final ObjectArrayCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1565007328, "Lcom/alibaba/fastjson/serializer/ObjectArrayCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1565007328, "Lcom/alibaba/fastjson/serializer/ObjectArrayCodec;");
                return;
            }
        }
        instance = new ObjectArrayCodec();
    }

    public ObjectArrayCodec() {
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, defaultJSONParser, cls, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            int size = jSONArray.size();
            T t = (T) Array.newInstance(cls, size);
            for (int i2 = 0; i2 < size; i2++) {
                Object obj2 = jSONArray.get(i2);
                if (obj2 == jSONArray) {
                    Array.set(t, i2, t);
                } else if (cls.isArray()) {
                    if (!cls.isInstance(obj2)) {
                        obj2 = toObjectArray(defaultJSONParser, cls, (JSONArray) obj2);
                    }
                    Array.set(t, i2, obj2);
                } else {
                    if (obj2 instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj2;
                        int size2 = jSONArray2.size();
                        boolean z = false;
                        for (int i3 = 0; i3 < size2; i3++) {
                            if (jSONArray2.get(i3) == jSONArray) {
                                jSONArray2.set(i2, t);
                                z = true;
                            }
                        }
                        if (z) {
                            obj = jSONArray2.toArray();
                            if (obj == null) {
                                obj = TypeUtils.cast(obj2, (Class<Object>) cls, defaultJSONParser.getConfig());
                            }
                            Array.set(t, i2, obj);
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                    Array.set(t, i2, obj);
                }
            }
            jSONArray.setRelatedArray(t);
            jSONArray.setComponentType(cls);
            return t;
        }
        return (T) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0063 */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, byte[]] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Type componentType;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = jSONLexer.token();
            Type type2 = 0;
            if (i2 == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else if (i2 != 4 && i2 != 26) {
                if (type instanceof GenericArrayType) {
                    componentType = ((GenericArrayType) type).getGenericComponentType();
                    if (componentType instanceof TypeVariable) {
                        TypeVariable typeVariable = (TypeVariable) componentType;
                        Type type3 = defaultJSONParser.getContext().type;
                        if (type3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) type3;
                            Type rawType = parameterizedType.getRawType();
                            if (rawType instanceof Class) {
                                TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                                for (int i3 = 0; i3 < typeParameters.length; i3++) {
                                    if (typeParameters[i3].getName().equals(typeVariable.getName())) {
                                        type2 = parameterizedType.getActualTypeArguments()[i3];
                                    }
                                }
                            }
                            if (type2 instanceof Class) {
                                cls = type2;
                            } else {
                                cls = Object.class;
                            }
                        } else {
                            cls = TypeUtils.getClass(typeVariable.getBounds()[0]);
                        }
                    } else {
                        cls = TypeUtils.getClass(componentType);
                    }
                } else {
                    componentType = ((Class) type).getComponentType();
                    cls = componentType;
                }
                JSONArray jSONArray = new JSONArray();
                defaultJSONParser.parseArray(componentType, jSONArray, obj);
                return (T) toObjectArray(defaultJSONParser, cls, jSONArray);
            } else {
                ?? r8 = (T) jSONLexer.bytesValue();
                jSONLexer.nextToken(16);
                if (r8.length != 0 || type == byte[].class) {
                    return r8;
                }
                return null;
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
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            Object[] objArr = (Object[]) obj;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
                return;
            }
            int length = objArr.length;
            int i3 = length - 1;
            if (i3 == -1) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            SerialContext serialContext = jSONSerializer.context;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            try {
                serializeWriter.append('[');
                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    jSONSerializer.incrementIndent();
                    jSONSerializer.println();
                    for (int i4 = 0; i4 < length; i4++) {
                        if (i4 != 0) {
                            serializeWriter.write(44);
                            jSONSerializer.println();
                        }
                        jSONSerializer.write(objArr[i4]);
                    }
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                    serializeWriter.write(93);
                    return;
                }
                Class<?> cls = null;
                ObjectSerializer objectSerializer = null;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj3 = objArr[i5];
                    if (obj3 == null) {
                        serializeWriter.append((CharSequence) "null,");
                    } else {
                        if (jSONSerializer.containsReference(obj3)) {
                            jSONSerializer.writeReference(obj3);
                        } else {
                            Class<?> cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                objectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i5), null, 0);
                            } else {
                                objectSerializer = jSONSerializer.getObjectWriter(cls2);
                                objectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i5), null, 0);
                                cls = cls2;
                            }
                        }
                        serializeWriter.append(',');
                    }
                }
                Object obj4 = objArr[i3];
                if (obj4 == null) {
                    serializeWriter.append((CharSequence) "null]");
                } else {
                    if (jSONSerializer.containsReference(obj4)) {
                        jSONSerializer.writeReference(obj4);
                    } else {
                        jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i3));
                    }
                    serializeWriter.append(']');
                }
            } finally {
                jSONSerializer.context = serialContext;
            }
        }
    }
}
