package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] gM;
    private Type gN;
    private Class<?> gO;

    public c(Type type) {
        this.gM = null;
        this.gN = null;
        this.gO = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.gM = parameterizedType.getActualTypeArguments();
            this.gN = parameterizedType.getRawType();
            if (this.gM != null && this.gM.length > 0) {
                try {
                    this.gO = (Class) this.gN;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.gO = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] cr() {
        return this.gM;
    }

    public Class<?> cs() {
        return this.gO;
    }
}
