package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] IR;
    private Type IS;
    private Class<?> fieldClass;

    public c(Type type) {
        this.IR = null;
        this.IS = null;
        this.fieldClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.IR = parameterizedType.getActualTypeArguments();
            this.IS = parameterizedType.getRawType();
            if (this.IR != null && this.IR.length > 0) {
                try {
                    this.fieldClass = (Class) this.IS;
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

    public Type[] jW() {
        return this.IR;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }
}
