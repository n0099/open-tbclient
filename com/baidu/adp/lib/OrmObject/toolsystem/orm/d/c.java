package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] zW;
    private Type zX;
    private Class<?> zY;

    public c(Type type) {
        this.zW = null;
        this.zX = null;
        this.zY = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.zW = parameterizedType.getActualTypeArguments();
            this.zX = parameterizedType.getRawType();
            if (this.zW != null && this.zW.length > 0) {
                try {
                    this.zY = (Class) this.zX;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.zY = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] hZ() {
        return this.zW;
    }

    public Class<?> ia() {
        return this.zY;
    }
}
