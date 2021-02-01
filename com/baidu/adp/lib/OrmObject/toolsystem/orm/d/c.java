package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] KJ;
    private Type KK;
    private Class<?> fieldClass;

    public c(Type type) {
        this.KJ = null;
        this.KK = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.KJ = parameterizedType.getActualTypeArguments();
            this.KK = parameterizedType.getRawType();
            if (this.KJ != null && this.KJ.length > 0) {
                try {
                    this.fieldClass = (Class) this.KK;
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
        return this.KJ;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
