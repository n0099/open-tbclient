package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double zR;

    public f(double d) {
        this.zR = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hY = cVar.hY();
        if (hY == Byte.class || hY == Byte.TYPE) {
            return Byte.valueOf(this.zR.byteValue());
        }
        if (hY == Short.class || hY == Short.TYPE) {
            return Short.valueOf(this.zR.shortValue());
        }
        if (hY == Integer.class || hY == Integer.TYPE) {
            return Integer.valueOf(this.zR.intValue());
        }
        if (hY == Long.class || hY == Long.TYPE) {
            return Long.valueOf(this.zR.longValue());
        }
        if (hY == Float.class || hY == Float.TYPE) {
            return Float.valueOf(this.zR.floatValue());
        }
        if (hY == Double.class || hY == Double.TYPE) {
            return Double.valueOf(this.zR.doubleValue());
        }
        if (hY == Character.class || hY == Character.TYPE) {
            return Character.valueOf((char) this.zR.intValue());
        }
        if (hY == Boolean.class || hY == Boolean.TYPE) {
            return Boolean.valueOf(this.zR.byteValue() == 0);
        } else if (hY == String.class) {
            return String.valueOf(this.zR);
        } else {
            if (hY == char[].class) {
                return String.valueOf(this.zR).toCharArray();
            }
            if (hY == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zR), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
