package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sC;

    public f(double d) {
        this.sC = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf(this.sC.byteValue());
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf(this.sC.shortValue());
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.sC.intValue());
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.sC.longValue());
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.sC.floatValue());
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.sC.doubleValue());
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf((char) this.sC.intValue());
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(this.sC.byteValue() == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.sC);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.sC).toCharArray();
            }
            if (eh == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sC), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
