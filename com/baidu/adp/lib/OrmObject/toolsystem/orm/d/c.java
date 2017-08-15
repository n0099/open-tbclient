package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] us;
    private Type ut;
    private Class<?> uu;

    public c(Type type) {
        this.us = null;
        this.ut = null;
        this.uu = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.us = parameterizedType.getActualTypeArguments();
            this.ut = parameterizedType.getRawType();
            if (this.us != null && this.us.length > 0) {
                try {
                    this.uu = (Class) this.ut;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.uu = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] er() {
        return this.us;
    }

    public Class<?> es() {
        return this.uu;
    }
}
