package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float sD;

    public g(float f) {
        this.sD = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf(this.sD.byteValue());
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf(this.sD.shortValue());
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.sD.intValue());
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.sD.longValue());
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.sD.floatValue());
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.sD.doubleValue());
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf((char) this.sD.intValue());
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(this.sD.byteValue() == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.sD);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.sD).toCharArray();
            }
            if (eh == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sD), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
