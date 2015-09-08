package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sq;
    private Type sr;
    private Class<?> ss;

    public c(Type type) {
        this.sq = null;
        this.sr = null;
        this.ss = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sq = parameterizedType.getActualTypeArguments();
            this.sr = parameterizedType.getRawType();
            if (this.sq != null && this.sq.length > 0) {
                try {
                    this.ss = (Class) this.sr;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.ss = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fK() {
        return this.sq;
    }

    public Class<?> fL() {
        return this.ss;
    }
}
