package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] IC;
    private Type IE;
    private Class<?> fieldClass;

    public c(Type type) {
        this.IC = null;
        this.IE = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.IC = parameterizedType.getActualTypeArguments();
            this.IE = parameterizedType.getRawType();
            if (this.IC != null && this.IC.length > 0) {
                try {
                    this.fieldClass = (Class) this.IE;
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
        return this.IC;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
