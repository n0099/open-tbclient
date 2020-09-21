package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Kd;
    private Type Ke;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Kd = null;
        this.Ke = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Kd = parameterizedType.getActualTypeArguments();
            this.Ke = parameterizedType.getRawType();
            if (this.Kd != null && this.Kd.length > 0) {
                try {
                    this.fieldClass = (Class) this.Ke;
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

    public Type[] lP() {
        return this.Kd;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
