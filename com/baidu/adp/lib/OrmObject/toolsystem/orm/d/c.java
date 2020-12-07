package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Lm;
    private Type Ln;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Lm = null;
        this.Ln = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Lm = parameterizedType.getActualTypeArguments();
            this.Ln = parameterizedType.getRawType();
            if (this.Lm != null && this.Lm.length > 0) {
                try {
                    this.fieldClass = (Class) this.Ln;
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
        return this.Lm;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
