package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] xc;
    private Type xd;
    private Class<?> xe;

    public c(Type type) {
        this.xc = null;
        this.xd = null;
        this.xe = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.xc = parameterizedType.getActualTypeArguments();
            this.xd = parameterizedType.getRawType();
            if (this.xc != null && this.xc.length > 0) {
                try {
                    this.xe = (Class) this.xd;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.xe = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gF() {
        return this.xc;
    }

    public Class<?> gG() {
        return this.xe;
    }
}
