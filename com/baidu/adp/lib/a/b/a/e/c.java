package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] ls;
    private Type lt;
    private Class<?> lu;

    public c(Type type) {
        this.ls = null;
        this.lt = null;
        this.lu = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.ls = parameterizedType.getActualTypeArguments();
            this.lt = parameterizedType.getRawType();
            if (this.ls != null && this.ls.length > 0) {
                try {
                    this.lu = (Class) this.lt;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.lu = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] dc() {
        return this.ls;
    }

    public Class<?> dd() {
        return this.lu;
    }
}
