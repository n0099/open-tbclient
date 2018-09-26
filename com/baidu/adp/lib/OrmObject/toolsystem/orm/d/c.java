package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] zn;
    private Type zo;
    private Class<?> zp;

    public c(Type type) {
        this.zn = null;
        this.zo = null;
        this.zp = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.zn = parameterizedType.getActualTypeArguments();
            this.zo = parameterizedType.getRawType();
            if (this.zn != null && this.zn.length > 0) {
                try {
                    this.zp = (Class) this.zo;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.zp = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] hK() {
        return this.zn;
    }

    public Class<?> hL() {
        return this.zp;
    }
}
