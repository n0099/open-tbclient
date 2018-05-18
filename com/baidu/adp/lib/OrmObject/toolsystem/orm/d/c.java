package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] qN;
    private Type qO;
    private Class<?> qP;

    public c(Type type) {
        this.qN = null;
        this.qO = null;
        this.qP = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.qN = parameterizedType.getActualTypeArguments();
            this.qO = parameterizedType.getRawType();
            if (this.qN != null && this.qN.length > 0) {
                try {
                    this.qP = (Class) this.qO;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.qP = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] dO() {
        return this.qN;
    }

    public Class<?> dP() {
        return this.qP;
    }
}
