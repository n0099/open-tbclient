package com.baidu.gson.internal.bind;

import com.baidu.gson.FieldNamingStrategy;
import com.baidu.gson.Gson;
import com.baidu.gson.JsonSyntaxException;
import com.baidu.gson.TypeAdapter;
import com.baidu.gson.TypeAdapterFactory;
import com.baidu.gson.annotations.SerializedName;
import com.baidu.gson.internal.C$Gson$Types;
import com.baidu.gson.internal.ConstructorConstructor;
import com.baidu.gson.internal.Excluder;
import com.baidu.gson.internal.ObjectConstructor;
import com.baidu.gson.internal.Primitives;
import com.baidu.gson.reflect.TypeToken;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonToken;
import com.baidu.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
    }

    public final boolean excludeField(Field field, boolean z) {
        return (this.excluder.excludeClass(field.getType(), z) || this.excluder.excludeField(field, z)) ? false : true;
    }

    private String getFieldName(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        return serializedName == null ? this.fieldNamingPolicy.translateName(field) : serializedName.value();
    }

    @Override // com.baidu.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType), null);
        }
        return null;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        return new BoundField(str, z, z2, gson, typeToken, field, Primitives.isPrimitive(typeToken.getRawType())) { // from class: com.baidu.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final TypeAdapter<?> typeAdapter;
            private final /* synthetic */ Gson val$context;
            private final /* synthetic */ Field val$field;
            private final /* synthetic */ TypeToken val$fieldType;
            private final /* synthetic */ boolean val$isPrimitive;

            {
                this.val$context = gson;
                this.val$fieldType = typeToken;
                this.val$field = field;
                this.val$isPrimitive = r9;
                this.typeAdapter = gson.getAdapter(typeToken);
            }

            @Override // com.baidu.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) {
                new TypeAdapterRuntimeTypeWrapper(this.val$context, this.typeAdapter, this.val$fieldType.getType()).write(jsonWriter, this.val$field.get(obj));
            }

            @Override // com.baidu.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) {
                Object read = this.typeAdapter.read(jsonReader);
                if (read != null || !this.val$isPrimitive) {
                    this.val$field.set(obj, read);
                }
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        Field[] declaredFields;
        BoundField boundField;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, false);
                if (excludeField || excludeField2) {
                    field.setAccessible(true);
                    BoundField createBoundField = createBoundField(gson, field, getFieldName(field), TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, field.getGenericType())), excludeField, excludeField2);
                    if (((BoundField) linkedHashMap.put(createBoundField.name, createBoundField)) != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                    }
                }
            }
            typeToken = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, cls.getGenericSuperclass()));
            cls = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj);

        abstract void write(JsonWriter jsonWriter, Object obj);

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    /* loaded from: classes.dex */
    public final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        private Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        /* synthetic */ Adapter(ObjectConstructor objectConstructor, Map map, Adapter adapter) {
            this(objectConstructor, map);
        }

        @Override // com.baidu.gson.TypeAdapter
        public final T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.baidu.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.serialized) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
