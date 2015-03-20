package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] si;
    private Type sj;
    private Class<?> sk;

    public c(Type type) {
        this.si = null;
        this.sj = null;
        this.sk = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.si = parameterizedType.getActualTypeArguments();
            this.sj = parameterizedType.getRawType();
            if (this.si != null && this.si.length > 0) {
                try {
                    this.sk = (Class) this.sj;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sk = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fN() {
        return this.si;
    }

    public Class<?> fO() {
        return this.sk;
    }
}
