package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double zS;

    public f(double d) {
        this.zS = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hY = cVar.hY();
        if (hY == Byte.class || hY == Byte.TYPE) {
            return Byte.valueOf(this.zS.byteValue());
        }
        if (hY == Short.class || hY == Short.TYPE) {
            return Short.valueOf(this.zS.shortValue());
        }
        if (hY == Integer.class || hY == Integer.TYPE) {
            return Integer.valueOf(this.zS.intValue());
        }
        if (hY == Long.class || hY == Long.TYPE) {
            return Long.valueOf(this.zS.longValue());
        }
        if (hY == Float.class || hY == Float.TYPE) {
            return Float.valueOf(this.zS.floatValue());
        }
        if (hY == Double.class || hY == Double.TYPE) {
            return Double.valueOf(this.zS.doubleValue());
        }
        if (hY == Character.class || hY == Character.TYPE) {
            return Character.valueOf((char) this.zS.intValue());
        }
        if (hY == Boolean.class || hY == Boolean.TYPE) {
            return Boolean.valueOf(this.zS.byteValue() == 0);
        } else if (hY == String.class) {
            return String.valueOf(this.zS);
        } else {
            if (hY == char[].class) {
                return String.valueOf(this.zS).toCharArray();
            }
            if (hY == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zS), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
