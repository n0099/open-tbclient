package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] KL;
    private Type KM;
    private Class<?> fieldClass;

    public c(Type type) {
        this.KL = null;
        this.KM = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.KL = parameterizedType.getActualTypeArguments();
            this.KM = parameterizedType.getRawType();
            if (this.KL != null && this.KL.length > 0) {
                try {
                    this.fieldClass = (Class) this.KM;
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

    public Type[] lo() {
        return this.KL;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
