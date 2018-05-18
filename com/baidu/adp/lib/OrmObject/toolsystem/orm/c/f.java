package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double qH;

    public f(double d) {
        this.qH = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf(this.qH.byteValue());
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf(this.qH.shortValue());
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.qH.intValue());
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.qH.longValue());
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.qH.floatValue());
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.qH.doubleValue());
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) this.qH.intValue());
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.qH.byteValue() == 0);
        } else if (dP == String.class) {
            return String.valueOf(this.qH);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.qH).toCharArray();
            }
            if (dP == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.qH), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
