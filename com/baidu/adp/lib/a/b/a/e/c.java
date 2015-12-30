package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] st;
    private Type su;
    private Class<?> sv;

    public c(Type type) {
        this.st = null;
        this.su = null;
        this.sv = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.st = parameterizedType.getActualTypeArguments();
            this.su = parameterizedType.getRawType();
            if (this.st != null && this.st.length > 0) {
                try {
                    this.sv = (Class) this.su;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sv = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fK() {
        return this.st;
    }

    public Class<?> fL() {
        return this.sv;
    }
}
