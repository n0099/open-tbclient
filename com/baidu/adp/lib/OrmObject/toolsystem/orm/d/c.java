package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sa;
    private Type sb;
    private Class<?> sc;

    public c(Type type) {
        this.sa = null;
        this.sb = null;
        this.sc = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sa = parameterizedType.getActualTypeArguments();
            this.sb = parameterizedType.getRawType();
            if (this.sa != null && this.sa.length > 0) {
                try {
                    this.sc = (Class) this.sb;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sc = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ef() {
        return this.sa;
    }

    public Class<?> eg() {
        return this.sc;
    }
}
