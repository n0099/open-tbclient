package com.baidu.gson.internal.bind;

import com.baidu.gson.Gson;
import com.baidu.gson.TypeAdapter;
import com.baidu.gson.TypeAdapterFactory;
import com.baidu.gson.internal.C$Gson$Types;
import com.baidu.gson.reflect.TypeToken;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonToken;
import com.baidu.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.baidu.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.baidu.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.baidu.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        Object newInstance = Array.newInstance((Class<?>) this.componentType, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.gson.TypeAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
