package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Class<?> Aa;
    private Type[] zY;
    private Type zZ;

    public c(Type type) {
        this.zY = null;
        this.zZ = null;
        this.Aa = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.zY = parameterizedType.getActualTypeArguments();
            this.zZ = parameterizedType.getRawType();
            if (this.zY != null && this.zY.length > 0) {
                try {
                    this.Aa = (Class) this.zZ;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.Aa = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] hX() {
        return this.zY;
    }

    public Class<?> hY() {
        return this.Aa;
    }
}
