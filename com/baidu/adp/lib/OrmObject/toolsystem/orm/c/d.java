package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte zg;

    public d(byte b) {
        this.zg = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf(this.zg.byteValue());
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf(this.zg.shortValue());
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.zg.intValue());
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.zg.longValue());
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.zg.floatValue());
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.zg.doubleValue());
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) this.zg.intValue());
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.zg.byteValue() == 0);
        } else if (hL == String.class) {
            return String.valueOf(this.zg);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.zg).toCharArray();
            }
            if (hL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zg), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
