package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double wW;

    public f(double d) {
        this.wW = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        if (gG == Byte.class || gG == Byte.TYPE) {
            return Byte.valueOf(this.wW.byteValue());
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf(this.wW.shortValue());
        }
        if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.wW.intValue());
        }
        if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.wW.longValue());
        }
        if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.wW.floatValue());
        }
        if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.wW.doubleValue());
        }
        if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf((char) this.wW.intValue());
        }
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(this.wW.byteValue() == 0);
        } else if (gG == String.class) {
            return String.valueOf(this.wW);
        } else {
            if (gG == char[].class) {
                return String.valueOf(this.wW).toCharArray();
            }
            if (gG == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wW), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
