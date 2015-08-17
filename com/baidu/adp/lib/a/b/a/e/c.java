package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] ss;
    private Type st;
    private Class<?> su;

    public c(Type type) {
        this.ss = null;
        this.st = null;
        this.su = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.ss = parameterizedType.getActualTypeArguments();
            this.st = parameterizedType.getRawType();
            if (this.ss != null && this.ss.length > 0) {
                try {
                    this.su = (Class) this.st;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.su = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fN() {
        return this.ss;
    }

    public Class<?> fO() {
        return this.su;
    }
}
