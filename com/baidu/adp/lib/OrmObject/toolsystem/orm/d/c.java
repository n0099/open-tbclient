package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] wU;
    private Type wV;
    private Class<?> wW;

    public c(Type type) {
        this.wU = null;
        this.wV = null;
        this.wW = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.wU = parameterizedType.getActualTypeArguments();
            this.wV = parameterizedType.getRawType();
            if (this.wU != null && this.wU.length > 0) {
                try {
                    this.wW = (Class) this.wV;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.wW = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gE() {
        return this.wU;
    }

    public Class<?> gF() {
        return this.wW;
    }
}
