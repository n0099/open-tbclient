package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] lm;
    private Type ln;
    private Class<?> lo;

    public c(Type type) {
        this.lm = null;
        this.ln = null;
        this.lo = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.lm = parameterizedType.getActualTypeArguments();
            this.ln = parameterizedType.getRawType();
            if (this.lm != null && this.lm.length > 0) {
                try {
                    this.lo = (Class) this.ln;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.lo = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] da() {
        return this.lm;
    }

    public Class<?> db() {
        return this.lo;
    }
}
