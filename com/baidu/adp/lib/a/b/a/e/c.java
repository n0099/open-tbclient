package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] lr;
    private Type ls;
    private Class<?> lt;

    public c(Type type) {
        this.lr = null;
        this.ls = null;
        this.lt = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.lr = parameterizedType.getActualTypeArguments();
            this.ls = parameterizedType.getRawType();
            if (this.lr != null && this.lr.length > 0) {
                try {
                    this.lt = (Class) this.ls;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.lt = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] dc() {
        return this.lr;
    }

    public Class<?> dd() {
        return this.lt;
    }
}
