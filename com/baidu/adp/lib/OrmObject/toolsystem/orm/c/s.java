package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short qN;

    public s(short s) {
        this.qN = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf(this.qN.byteValue());
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf(this.qN.shortValue());
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.qN.intValue());
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.qN.longValue());
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.qN.floatValue());
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.qN.doubleValue());
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) this.qN.intValue());
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.qN.byteValue() == 0);
        } else if (dP == String.class) {
            return String.valueOf(this.qN);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.qN).toCharArray();
            }
            if (dP == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.qN), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
