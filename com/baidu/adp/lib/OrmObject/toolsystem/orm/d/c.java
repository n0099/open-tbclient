package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] th;
    private Type ti;
    private Class<?> tj;

    public c(Type type) {
        this.th = null;
        this.ti = null;
        this.tj = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.th = parameterizedType.getActualTypeArguments();
            this.ti = parameterizedType.getRawType();
            if (this.th != null && this.th.length > 0) {
                try {
                    this.tj = (Class) this.ti;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.tj = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ej() {
        return this.th;
    }

    public Class<?> ek() {
        return this.tj;
    }
}
