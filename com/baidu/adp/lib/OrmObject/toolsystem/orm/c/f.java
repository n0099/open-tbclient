package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double xI;

    public f(double d) {
        this.xI = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hb = cVar.hb();
        if (hb == Byte.class || hb == Byte.TYPE) {
            return Byte.valueOf(this.xI.byteValue());
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf(this.xI.shortValue());
        }
        if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(this.xI.intValue());
        }
        if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(this.xI.longValue());
        }
        if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(this.xI.floatValue());
        }
        if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(this.xI.doubleValue());
        }
        if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf((char) this.xI.intValue());
        }
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(this.xI.byteValue() == 0);
        } else if (hb == String.class) {
            return String.valueOf(this.xI);
        } else {
            if (hb == char[].class) {
                return String.valueOf(this.xI).toCharArray();
            }
            if (hb == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
