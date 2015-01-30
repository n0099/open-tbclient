package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] gO;
    private Type gP;
    private Class<?> gQ;

    public c(Type type) {
        this.gO = null;
        this.gP = null;
        this.gQ = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.gO = parameterizedType.getActualTypeArguments();
            this.gP = parameterizedType.getRawType();
            if (this.gO != null && this.gO.length > 0) {
                try {
                    this.gQ = (Class) this.gP;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.gQ = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] cp() {
        return this.gO;
    }

    public Class<?> cq() {
        return this.gQ;
    }
}
