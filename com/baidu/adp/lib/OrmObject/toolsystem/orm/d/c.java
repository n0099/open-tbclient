package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] KN;
    private Type KO;
    private Class<?> fieldClass;

    public c(Type type) {
        this.KN = null;
        this.KO = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.KN = parameterizedType.getActualTypeArguments();
            this.KO = parameterizedType.getRawType();
            if (this.KN != null && this.KN.length > 0) {
                try {
                    this.fieldClass = (Class) this.KO;
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
        return this.KN;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
