package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] ags;
    private Type agt;
    private Class<?> agu;

    public c(Type type) {
        this.ags = null;
        this.agt = null;
        this.agu = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.ags = parameterizedType.getActualTypeArguments();
            this.agt = parameterizedType.getRawType();
            if (this.ags != null && this.ags.length > 0) {
                try {
                    this.agu = (Class) this.agt;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.agu = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] lK() {
        return this.ags;
    }

    public Class<?> lL() {
        return this.agu;
    }
}
