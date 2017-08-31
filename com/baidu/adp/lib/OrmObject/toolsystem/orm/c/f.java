package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double rU;

    public f(double d) {
        this.rU = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf(this.rU.byteValue());
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf(this.rU.shortValue());
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.rU.intValue());
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.rU.longValue());
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.rU.floatValue());
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.rU.doubleValue());
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf((char) this.rU.intValue());
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(this.rU.byteValue() == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.rU);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.rU).toCharArray();
            }
            if (eh == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
