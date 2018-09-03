package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] wV;
    private Type wW;
    private Class<?> wX;

    public c(Type type) {
        this.wV = null;
        this.wW = null;
        this.wX = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.wV = parameterizedType.getActualTypeArguments();
            this.wW = parameterizedType.getRawType();
            if (this.wV != null && this.wV.length > 0) {
                try {
                    this.wX = (Class) this.wW;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.wX = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gE() {
        return this.wV;
    }

    public Class<?> gF() {
        return this.wX;
    }
}
