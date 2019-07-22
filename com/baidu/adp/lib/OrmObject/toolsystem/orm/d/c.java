package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] xO;
    private Type xP;
    private Class<?> xQ;

    public c(Type type) {
        this.xO = null;
        this.xP = null;
        this.xQ = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.xO = parameterizedType.getActualTypeArguments();
            this.xP = parameterizedType.getRawType();
            if (this.xO != null && this.xO.length > 0) {
                try {
                    this.xQ = (Class) this.xP;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.xQ = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] ha() {
        return this.xO;
    }

    public Class<?> hb() {
        return this.xQ;
    }
}
