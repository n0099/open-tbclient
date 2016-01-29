package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sC;
    private Type sD;
    private Class<?> sE;

    public c(Type type) {
        this.sC = null;
        this.sD = null;
        this.sE = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sC = parameterizedType.getActualTypeArguments();
            this.sD = parameterizedType.getRawType();
            if (this.sC != null && this.sC.length > 0) {
                try {
                    this.sE = (Class) this.sD;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sE = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fS() {
        return this.sC;
    }

    public Class<?> fT() {
        return this.sE;
    }
}
