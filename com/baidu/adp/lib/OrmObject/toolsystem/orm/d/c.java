package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] pC;
    private Type pD;
    private Class<?> pE;

    public c(Type type) {
        this.pC = null;
        this.pD = null;
        this.pE = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.pC = parameterizedType.getActualTypeArguments();
            this.pD = parameterizedType.getRawType();
            if (this.pC != null && this.pC.length > 0) {
                try {
                    this.pE = (Class) this.pD;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.pE = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] fo() {
        return this.pC;
    }

    public Class<?> fp() {
        return this.pE;
    }
}
