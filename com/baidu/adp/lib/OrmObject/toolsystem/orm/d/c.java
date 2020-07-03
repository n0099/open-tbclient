package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] Js;
    private Type Jt;
    private Class<?> fieldClass;

    public c(Type type) {
        this.Js = null;
        this.Jt = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.Js = parameterizedType.getActualTypeArguments();
            this.Jt = parameterizedType.getRawType();
            if (this.Js != null && this.Js.length > 0) {
                try {
                    this.fieldClass = (Class) this.Jt;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.fieldClass = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] km() {
        return this.Js;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
