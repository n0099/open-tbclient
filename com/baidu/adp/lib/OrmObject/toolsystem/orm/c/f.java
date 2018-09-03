package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double wP;

    public f(double d) {
        this.wP = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf(this.wP.byteValue());
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf(this.wP.shortValue());
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.wP.intValue());
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.wP.longValue());
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.wP.floatValue());
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.wP.doubleValue());
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) this.wP.intValue());
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.wP.byteValue() == 0);
        } else if (gF == String.class) {
            return String.valueOf(this.wP);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.wP).toCharArray();
            }
            if (gF == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wP), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
