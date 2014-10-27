package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] eL;
    private Type eM;
    private Class<?> eN;

    public c(Type type) {
        this.eL = null;
        this.eM = null;
        this.eN = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.eL = parameterizedType.getActualTypeArguments();
            this.eM = parameterizedType.getRawType();
            if (this.eL != null && this.eL.length > 0) {
                try {
                    this.eN = (Class) this.eM;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.eN = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] bR() {
        return this.eL;
    }

    public Class<?> bS() {
        return this.eN;
    }
}
