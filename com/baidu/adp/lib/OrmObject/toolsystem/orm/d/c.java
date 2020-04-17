package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Iy;
    private Type Iz;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Iy = null;
        this.Iz = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Iy = parameterizedType.getActualTypeArguments();
            this.Iz = parameterizedType.getRawType();
            if (this.Iy != null && this.Iy.length > 0) {
                try {
                    this.fieldClass = (Class) this.Iz;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.fieldClass = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] jU() {
        return this.Iy;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
