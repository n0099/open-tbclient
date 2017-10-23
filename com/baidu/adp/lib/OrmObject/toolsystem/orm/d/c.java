package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sc;
    private Type sd;
    private Class<?> se;

    public c(Type type) {
        this.sc = null;
        this.sd = null;
        this.se = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sc = parameterizedType.getActualTypeArguments();
            this.sd = parameterizedType.getRawType();
            if (this.sc != null && this.sc.length > 0) {
                try {
                    this.se = (Class) this.sd;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.se = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ef() {
        return this.sc;
    }

    public Class<?> eg() {
        return this.se;
    }
}
