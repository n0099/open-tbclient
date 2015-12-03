package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sr;
    private Type ss;
    private Class<?> st;

    public c(Type type) {
        this.sr = null;
        this.ss = null;
        this.st = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sr = parameterizedType.getActualTypeArguments();
            this.ss = parameterizedType.getRawType();
            if (this.sr != null && this.sr.length > 0) {
                try {
                    this.st = (Class) this.ss;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.st = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fK() {
        return this.sr;
    }

    public Class<?> fL() {
        return this.st;
    }
}
