package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] rZ;
    private Type sa;
    private Class<?> sb;

    public c(Type type) {
        this.rZ = null;
        this.sa = null;
        this.sb = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.rZ = parameterizedType.getActualTypeArguments();
            this.sa = parameterizedType.getRawType();
            if (this.rZ != null && this.rZ.length > 0) {
                try {
                    this.sb = (Class) this.sa;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sb = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ef() {
        return this.rZ;
    }

    public Class<?> eg() {
        return this.sb;
    }
}
