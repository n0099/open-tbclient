package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] xI;
    private Type xJ;
    private Class<?> xK;

    public c(Type type) {
        this.xI = null;
        this.xJ = null;
        this.xK = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.xI = parameterizedType.getActualTypeArguments();
            this.xJ = parameterizedType.getRawType();
            if (this.xI != null && this.xI.length > 0) {
                try {
                    this.xK = (Class) this.xJ;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.xK = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gR() {
        return this.xI;
    }

    public Class<?> gS() {
        return this.xK;
    }
}
