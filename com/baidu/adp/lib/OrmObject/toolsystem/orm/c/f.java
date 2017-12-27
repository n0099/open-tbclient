package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double agr;

    public f(double d) {
        this.agr = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(this.agr.byteValue());
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(this.agr.shortValue());
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.agr.intValue());
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.agr.longValue());
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.agr.floatValue());
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.agr.doubleValue());
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) this.agr.intValue());
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.agr.byteValue() == 0);
        } else if (lK == String.class) {
            return String.valueOf(this.agr);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.agr).toCharArray();
            }
            if (lK == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agr), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
