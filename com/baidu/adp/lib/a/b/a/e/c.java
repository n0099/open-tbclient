package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] iC;
    private Type iD;
    private Class<?> iE;

    public c(Type type) {
        this.iC = null;
        this.iD = null;
        this.iE = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.iC = parameterizedType.getActualTypeArguments();
            this.iD = parameterizedType.getRawType();
            if (this.iC != null && this.iC.length > 0) {
                try {
                    this.iE = (Class) this.iD;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.iE = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ch() {
        return this.iC;
    }

    public Class<?> ci() {
        return this.iE;
    }
}
