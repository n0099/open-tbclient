package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sJ;
    private Type sK;
    private Class<?> sL;

    public c(Type type) {
        this.sJ = null;
        this.sK = null;
        this.sL = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sJ = parameterizedType.getActualTypeArguments();
            this.sK = parameterizedType.getRawType();
            if (this.sJ != null && this.sJ.length > 0) {
                try {
                    this.sL = (Class) this.sK;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sL = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ei() {
        return this.sJ;
    }

    public Class<?> ej() {
        return this.sL;
    }
}
