package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double zh;

    public f(double d) {
        this.zh = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf(this.zh.byteValue());
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf(this.zh.shortValue());
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.zh.intValue());
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.zh.longValue());
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.zh.floatValue());
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.zh.doubleValue());
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) this.zh.intValue());
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.zh.byteValue() == 0);
        } else if (hL == String.class) {
            return String.valueOf(this.zh);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.zh).toCharArray();
            }
            if (hL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zh), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
