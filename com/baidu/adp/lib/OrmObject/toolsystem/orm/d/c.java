package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sE;
    private Type sF;
    private Class<?> sG;

    public c(Type type) {
        this.sE = null;
        this.sF = null;
        this.sG = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sE = parameterizedType.getActualTypeArguments();
            this.sF = parameterizedType.getRawType();
            if (this.sE != null && this.sE.length > 0) {
                try {
                    this.sG = (Class) this.sF;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sG = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ei() {
        return this.sE;
    }

    public Class<?> ej() {
        return this.sG;
    }
}
