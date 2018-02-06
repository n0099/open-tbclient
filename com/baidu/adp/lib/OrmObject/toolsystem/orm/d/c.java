package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Class<?> agA;
    private Type[] agy;
    private Type agz;

    public c(Type type) {
        this.agy = null;
        this.agz = null;
        this.agA = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.agy = parameterizedType.getActualTypeArguments();
            this.agz = parameterizedType.getRawType();
            if (this.agy != null && this.agy.length > 0) {
                try {
                    this.agA = (Class) this.agz;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.agA = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] lK() {
        return this.agy;
    }

    public Class<?> lL() {
        return this.agA;
    }
}
