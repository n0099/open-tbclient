package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Class<?> fieldClass;
    private Type[] pB;
    private Type pC;

    public c(Type type) {
        this.pB = null;
        this.pC = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.pB = parameterizedType.getActualTypeArguments();
            this.pC = parameterizedType.getRawType();
            if (this.pB != null && this.pB.length > 0) {
                try {
                    this.fieldClass = (Class) this.pC;
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
        return this.pB;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
