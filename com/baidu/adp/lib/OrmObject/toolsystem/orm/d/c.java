package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] nc;
    private Type nd;
    private Class<?> ne;

    public c(Type type) {
        this.nc = null;
        this.nd = null;
        this.ne = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.nc = parameterizedType.getActualTypeArguments();
            this.nd = parameterizedType.getRawType();
            if (this.nc != null && this.nc.length > 0) {
                try {
                    this.ne = (Class) this.nd;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.ne = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] eU() {
        return this.nc;
    }

    public Class<?> eV() {
        return this.ne;
    }
}
