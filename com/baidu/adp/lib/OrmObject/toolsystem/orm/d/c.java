package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] xa;
    private Type xb;
    private Class<?> xc;

    public c(Type type) {
        this.xa = null;
        this.xb = null;
        this.xc = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.xa = parameterizedType.getActualTypeArguments();
            this.xb = parameterizedType.getRawType();
            if (this.xa != null && this.xa.length > 0) {
                try {
                    this.xc = (Class) this.xb;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.xc = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gF() {
        return this.xa;
    }

    public Class<?> gG() {
        return this.xc;
    }
}
