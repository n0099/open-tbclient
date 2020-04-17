package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes7.dex */
public class ObjectArrayCodec implements ObjectDeserializer, ObjectSerializer {
    public static final ObjectArrayCodec instance = new ObjectArrayCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Class<?> cls;
        SerializeWriter serializeWriter = jSONSerializer.out;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i2 = length - 1;
        if (i2 == -1) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        Class<?> cls2 = null;
        try {
            serializeWriter.append('[');
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.write(objArr[i3]);
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            int i4 = 0;
            ObjectSerializer objectSerializer = null;
            while (i4 < i2) {
                Object obj3 = objArr[i4];
                if (obj3 == null) {
                    serializeWriter.append((CharSequence) "null,");
                    cls = cls2;
                } else {
                    if (jSONSerializer.containsReference(obj3)) {
                        jSONSerializer.writeReference(obj3);
                        cls = cls2;
                    } else {
                        Class<?> cls3 = obj3.getClass();
                        if (cls3 == cls2) {
                            objectSerializer.write(jSONSerializer, obj3, null, null, 0);
                            cls = cls2;
                        } else {
                            objectSerializer = jSONSerializer.getObjectWriter(cls3);
                            objectSerializer.write(jSONSerializer, obj3, null, null, 0);
                            cls = cls3;
                        }
                    }
                    serializeWriter.append(',');
                }
                i4++;
                cls2 = cls;
            }
            Object obj4 = objArr[i2];
            if (obj4 == null) {
                serializeWriter.append((CharSequence) "null]");
            } else {
                if (jSONSerializer.containsReference(obj4)) {
                    jSONSerializer.writeReference(obj4);
                } else {
                    jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i2));
                }
                serializeWriter.append(']');
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x006e */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, byte[]] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Type componentType;
        Class<?> cls;
        Object[] objArr;
        int i = 0;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token();
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i2 == 4 || i2 == 26) {
            ?? r0 = (T) jSONLexer.bytesValue();
            jSONLexer.nextToken(16);
            if (r0.length != 0 || type == byte[].class) {
                return r0;
            }
            return null;
        } else {
            if (type instanceof GenericArrayType) {
                componentType = ((GenericArrayType) type).getGenericComponentType();
                if (componentType instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) componentType;
                    Type type2 = defaultJSONParser.getContext().type;
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        Type rawType = parameterizedType.getRawType();
                        if (rawType instanceof Class) {
                            TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                            Object[] objArr2 = null;
                            while (i < typeParameters.length) {
                                if (typeParameters[i].getName().equals(typeVariable.getName())) {
                                    objArr2 = parameterizedType.getActualTypeArguments()[i];
                                }
                                i++;
                                objArr2 = objArr2;
                            }
                            objArr = objArr2;
                        } else {
                            objArr = null;
                        }
                        if (objArr instanceof Class) {
                            cls = (Class) objArr;
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
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        Object[] objArr;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t = (T) Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            if (obj == jSONArray) {
                Array.set(t, i, t);
            } else if (cls.isArray()) {
                if (!cls.isInstance(obj)) {
                    obj = toObjectArray(defaultJSONParser, cls, (JSONArray) obj);
                }
                Array.set(t, i, obj);
            } else {
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    int size2 = jSONArray2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (jSONArray2.get(i2) == jSONArray) {
                            jSONArray2.set(i, t);
                            z = true;
                        }
                    }
                    if (z) {
                        objArr = jSONArray2.toArray();
                        Array.set(t, i, objArr != null ? TypeUtils.cast(obj, (Class<Object>) cls, defaultJSONParser.getConfig()) : objArr);
                    }
                }
                objArr = null;
                Array.set(t, i, objArr != null ? TypeUtils.cast(obj, (Class<Object>) cls, defaultJSONParser.getConfig()) : objArr);
            }
        }
        jSONArray.setRelatedArray(t);
        jSONArray.setComponentType(cls);
        return t;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }
}
