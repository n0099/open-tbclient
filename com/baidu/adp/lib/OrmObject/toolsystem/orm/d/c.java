package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] uq;
    private Type ur;
    private Class<?> us;

    public c(Type type) {
        this.uq = null;
        this.ur = null;
        this.us = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.uq = parameterizedType.getActualTypeArguments();
            this.ur = parameterizedType.getRawType();
            if (this.uq != null && this.uq.length > 0) {
                try {
                    this.us = (Class) this.ur;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.us = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] er() {
        return this.uq;
    }

    public Class<?> es() {
        return this.us;
    }
}
