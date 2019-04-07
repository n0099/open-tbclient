package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] zX;
    private Type zY;
    private Class<?> zZ;

    public c(Type type) {
        this.zX = null;
        this.zY = null;
        this.zZ = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.zX = parameterizedType.getActualTypeArguments();
            this.zY = parameterizedType.getRawType();
            if (this.zX != null && this.zX.length > 0) {
                try {
                    this.zZ = (Class) this.zY;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.zZ = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] hX() {
        return this.zX;
    }

    public Class<?> hY() {
        return this.zZ;
    }
}
