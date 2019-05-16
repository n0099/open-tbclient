package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class c {
    private Type[] xJ;
    private Type xK;
    private Class<?> xL;

    public c(Type type) {
        this.xJ = null;
        this.xK = null;
        this.xL = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.xJ = parameterizedType.getActualTypeArguments();
            this.xK = parameterizedType.getRawType();
            if (this.xJ != null && this.xJ.length > 0) {
                try {
                    this.xL = (Class) this.xK;
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            this.xL = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Type[] gR() {
        return this.xJ;
    }

    public Class<?> gS() {
        return this.xL;
    }
}
