package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] qO;
    private Type qP;
    private Class<?> qQ;

    public c(Type type) {
        this.qO = null;
        this.qP = null;
        this.qQ = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.qO = parameterizedType.getActualTypeArguments();
            this.qP = parameterizedType.getRawType();
            if (this.qO != null && this.qO.length > 0) {
                try {
                    this.qQ = (Class) this.qP;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.qQ = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] dO() {
        return this.qO;
    }

    public Class<?> dP() {
        return this.qQ;
    }
}
