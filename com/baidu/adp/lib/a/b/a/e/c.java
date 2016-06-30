package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] iA;
    private Type iB;
    private Class<?> iC;

    public c(Type type) {
        this.iA = null;
        this.iB = null;
        this.iC = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.iA = parameterizedType.getActualTypeArguments();
            this.iB = parameterizedType.getRawType();
            if (this.iA != null && this.iA.length > 0) {
                try {
                    this.iC = (Class) this.iB;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.iC = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ci() {
        return this.iA;
    }

    public Class<?> cj() {
        return this.iC;
    }
}
