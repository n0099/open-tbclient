package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] agA;
    private Type agB;
    private Class<?> agC;

    public c(Type type) {
        this.agA = null;
        this.agB = null;
        this.agC = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.agA = parameterizedType.getActualTypeArguments();
            this.agB = parameterizedType.getRawType();
            if (this.agA != null && this.agA.length > 0) {
                try {
                    this.agC = (Class) this.agB;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.agC = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] lK() {
        return this.agA;
    }

    public Class<?> lL() {
        return this.agC;
    }
}
