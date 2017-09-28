package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] sb;
    private Type sc;
    private Class<?> sd;

    public c(Type type) {
        this.sb = null;
        this.sc = null;
        this.sd = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.sb = parameterizedType.getActualTypeArguments();
            this.sc = parameterizedType.getRawType();
            if (this.sb != null && this.sb.length > 0) {
                try {
                    this.sd = (Class) this.sc;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.sd = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ef() {
        return this.sb;
    }

    public Class<?> eg() {
        return this.sd;
    }
}
