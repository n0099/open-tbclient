package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sv;
    private Type sw;
    private Class<?> sx;

    public c(Type type) {
        this.sv = null;
        this.sw = null;
        this.sx = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sv = parameterizedType.getActualTypeArguments();
            this.sw = parameterizedType.getRawType();
            if (this.sv != null && this.sv.length > 0) {
                try {
                    this.sx = (Class) this.sw;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sx = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fS() {
        return this.sv;
    }

    public Class<?> fT() {
        return this.sx;
    }
}
