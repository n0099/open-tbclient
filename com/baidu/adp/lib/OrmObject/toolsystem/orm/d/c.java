package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type pA;
    private Class<?> pB;
    private Type[] pz;

    public c(Type type) {
        this.pz = null;
        this.pA = null;
        this.pB = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.pz = parameterizedType.getActualTypeArguments();
            this.pA = parameterizedType.getRawType();
            if (this.pz != null && this.pz.length > 0) {
                try {
                    this.pB = (Class) this.pA;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.pB = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fo() {
        return this.pz;
    }

    public Class<?> fp() {
        return this.pB;
    }
}
