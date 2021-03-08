package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Mh;
    private Type Mi;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Mh = null;
        this.Mi = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Mh = parameterizedType.getActualTypeArguments();
            this.Mi = parameterizedType.getRawType();
            if (this.Mh != null && this.Mh.length > 0) {
                try {
                    this.fieldClass = (Class) this.Mi;
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

    public Type[] ln() {
        return this.Mh;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
