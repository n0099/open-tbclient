package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double qI;

    public f(double d) {
        this.qI = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf(this.qI.byteValue());
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf(this.qI.shortValue());
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.qI.intValue());
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.qI.longValue());
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.qI.floatValue());
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.qI.doubleValue());
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) this.qI.intValue());
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.qI.byteValue() == 0);
        } else if (dP == String.class) {
            return String.valueOf(this.qI);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.qI).toCharArray();
            }
            if (dP == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.qI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
