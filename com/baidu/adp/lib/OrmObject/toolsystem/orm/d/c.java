package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type Aa;
    private Class<?> Ab;
    private Type[] zZ;

    public c(Type type) {
        this.zZ = null;
        this.Aa = null;
        this.Ab = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.zZ = parameterizedType.getActualTypeArguments();
            this.Aa = parameterizedType.getRawType();
            if (this.zZ != null && this.zZ.length > 0) {
                try {
                    this.Ab = (Class) this.Aa;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.Ab = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] hY() {
        return this.zZ;
    }

    public Class<?> hZ() {
        return this.Ab;
    }
}
