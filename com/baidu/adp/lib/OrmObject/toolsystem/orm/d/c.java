package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] nC;
    private Type nD;
    private Class<?> nE;

    public c(Type type) {
        this.nC = null;
        this.nD = null;
        this.nE = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.nC = parameterizedType.getActualTypeArguments();
            this.nD = parameterizedType.getRawType();
            if (this.nC != null && this.nC.length > 0) {
                try {
                    this.nE = (Class) this.nD;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.nE = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] eU() {
        return this.nC;
    }

    public Class<?> eV() {
        return this.nE;
    }
}
