package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] actualTypeArguments;
    private final Type ownerType;
    private final Type rawType;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.actualTypeArguments = typeArr;
        this.ownerType = type;
        this.rawType = type2;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
        if (Arrays.equals(this.actualTypeArguments, parameterizedTypeImpl.actualTypeArguments)) {
            if (this.ownerType != null) {
                if (!this.ownerType.equals(parameterizedTypeImpl.ownerType)) {
                    return false;
                }
            } else if (parameterizedTypeImpl.ownerType != null) {
                return false;
            }
            if (this.rawType != null) {
                z = this.rawType.equals(parameterizedTypeImpl.rawType);
            } else if (parameterizedTypeImpl.rawType != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.ownerType != null ? this.ownerType.hashCode() : 0) + ((this.actualTypeArguments != null ? Arrays.hashCode(this.actualTypeArguments) : 0) * 31)) * 31) + (this.rawType != null ? this.rawType.hashCode() : 0);
    }
}
