package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] jc;
    private Type jd;
    private Class<?> je;

    public c(Type type) {
        this.jc = null;
        this.jd = null;
        this.je = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.jc = parameterizedType.getActualTypeArguments();
            this.jd = parameterizedType.getRawType();
            if (this.jc != null && this.jc.length > 0) {
                try {
                    this.je = (Class) this.jd;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.je = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ch() {
        return this.jc;
    }

    public Class<?> ci() {
        return this.je;
    }
}
