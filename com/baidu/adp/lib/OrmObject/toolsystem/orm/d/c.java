package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Kt;
    private Type Ku;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Kt = null;
        this.Ku = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Kt = parameterizedType.getActualTypeArguments();
            this.Ku = parameterizedType.getRawType();
            if (this.Kt != null && this.Kt.length > 0) {
                try {
                    this.fieldClass = (Class) this.Ku;
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

    public Type[] lQ() {
        return this.Kt;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
