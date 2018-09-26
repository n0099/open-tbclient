package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float zi;

    public g(float f) {
        this.zi = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf(this.zi.byteValue());
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf(this.zi.shortValue());
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.zi.intValue());
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.zi.longValue());
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.zi.floatValue());
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.zi.doubleValue());
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) this.zi.intValue());
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.zi.byteValue() == 0);
        } else if (hL == String.class) {
            return String.valueOf(this.zi);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.zi).toCharArray();
            }
            if (hL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zi), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
