package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sK;
    private Type sL;
    private Class<?> sM;

    public c(Type type) {
        this.sK = null;
        this.sL = null;
        this.sM = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sK = parameterizedType.getActualTypeArguments();
            this.sL = parameterizedType.getRawType();
            if (this.sK != null && this.sK.length > 0) {
                try {
                    this.sM = (Class) this.sL;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sM = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ej() {
        return this.sK;
    }

    public Class<?> ek() {
        return this.sM;
    }
}
