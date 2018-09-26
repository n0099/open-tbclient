package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short zm;

    public s(short s) {
        this.zm = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf(this.zm.byteValue());
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf(this.zm.shortValue());
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.zm.intValue());
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.zm.longValue());
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.zm.floatValue());
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.zm.doubleValue());
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) this.zm.intValue());
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.zm.byteValue() == 0);
        } else if (hL == String.class) {
            return String.valueOf(this.zm);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.zm).toCharArray();
            }
            if (hL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zm), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
