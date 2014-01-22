package com.baidu.gson.internal;

import com.baidu.gson.ExclusionStrategy;
import com.baidu.gson.FieldAttributes;
import com.baidu.gson.Gson;
import com.baidu.gson.TypeAdapter;
import com.baidu.gson.TypeAdapterFactory;
import com.baidu.gson.annotations.Expose;
import com.baidu.gson.annotations.Since;
import com.baidu.gson.annotations.Until;
import com.baidu.gson.reflect.TypeToken;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public Excluder m0clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Excluder withVersion(double d) {
        Excluder m0clone = m0clone();
        m0clone.version = d;
        return m0clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m0clone = m0clone();
        m0clone.modifiers = 0;
        for (int i : iArr) {
            m0clone.modifiers = i | m0clone.modifiers;
        }
        return m0clone;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m0clone = m0clone();
        m0clone.serializeInnerClasses = false;
        return m0clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m0clone = m0clone();
        m0clone.requireExpose = true;
        return m0clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder m0clone = m0clone();
        if (z) {
            m0clone.serializationStrategies = new ArrayList(this.serializationStrategies);
            m0clone.serializationStrategies.add(exclusionStrategy);
        }
        if (z2) {
            m0clone.deserializationStrategies = new ArrayList(this.deserializationStrategies);
            m0clone.deserializationStrategies.add(exclusionStrategy);
        }
        return m0clone;
    }

    @Override // com.baidu.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (excludeClass || excludeClass2) {
            return new TypeAdapter<T>() { // from class: com.baidu.gson.internal.Excluder.1
                private TypeAdapter<T> delegate;

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
                @Override // com.baidu.gson.TypeAdapter
                public T read(JsonReader jsonReader) {
                    if (excludeClass2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read(jsonReader);
                }

                @Override // com.baidu.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) {
                    if (excludeClass) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t);
                    }
                }

                private TypeAdapter<T> delegate() {
                    TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != 0) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version == IGNORE_VERSIONS || isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic()) {
            if (!this.requireExpose || ((expose = (Expose) field.getAnnotation(Expose.class)) != null && (!z ? !expose.deserialize() : !expose.serialize()))) {
                if ((this.serializeInnerClasses || !isInnerClass(field.getType())) && !isAnonymousOrLocal(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
                    if (!list.isEmpty()) {
                        FieldAttributes fieldAttributes = new FieldAttributes(field);
                        for (ExclusionStrategy exclusionStrategy : list) {
                            if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (this.version == IGNORE_VERSIONS || isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            if ((this.serializeInnerClasses || !isInnerClass(cls)) && !isAnonymousOrLocal(cls)) {
                for (ExclusionStrategy exclusionStrategy : z ? this.serializationStrategies : this.deserializationStrategies) {
                    if (exclusionStrategy.shouldSkipClass(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }
}
