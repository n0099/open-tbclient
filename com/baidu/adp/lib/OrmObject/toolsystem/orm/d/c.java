package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Class<?> fieldClass;
    private Type[] pA;
    private Type pB;

    public c(Type type) {
        this.pA = null;
        this.pB = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.pA = parameterizedType.getActualTypeArguments();
            this.pB = parameterizedType.getRawType();
            if (this.pA != null && this.pA.length > 0) {
                try {
                    this.fieldClass = (Class) this.pB;
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

    public Type[] fp() {
        return this.pA;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
