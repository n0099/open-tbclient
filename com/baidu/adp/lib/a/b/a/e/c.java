package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sL;
    private Type sM;
    private Class<?> sN;

    public c(Type type) {
        this.sL = null;
        this.sM = null;
        this.sN = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sL = parameterizedType.getActualTypeArguments();
            this.sM = parameterizedType.getRawType();
            if (this.sL != null && this.sL.length > 0) {
                try {
                    this.sN = (Class) this.sM;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sN = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fS() {
        return this.sL;
    }

    public Class<?> fT() {
        return this.sN;
    }
}
