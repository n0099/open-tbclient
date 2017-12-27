package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] agx;
    private Type agy;
    private Class<?> agz;

    public c(Type type) {
        this.agx = null;
        this.agy = null;
        this.agz = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.agx = parameterizedType.getActualTypeArguments();
            this.agy = parameterizedType.getRawType();
            if (this.agx != null && this.agx.length > 0) {
                try {
                    this.agz = (Class) this.agy;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.agz = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] lJ() {
        return this.agx;
    }

    public Class<?> lK() {
        return this.agz;
    }
}
