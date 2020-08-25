package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] JV;
    private Type JW;
    private Class<?> fieldClass;

    public c(Type type) {
        this.JV = null;
        this.JW = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.JV = parameterizedType.getActualTypeArguments();
            this.JW = parameterizedType.getRawType();
            if (this.JV != null && this.JV.length > 0) {
                try {
                    this.fieldClass = (Class) this.JW;
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

    public Type[] lL() {
        return this.JV;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
