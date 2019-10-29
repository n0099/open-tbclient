package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short nB;

    public s(short s) {
        this.nB = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(this.nB.byteValue());
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(this.nB.shortValue());
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.nB.intValue());
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.nB.longValue());
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.nB.floatValue());
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.nB.doubleValue());
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) this.nB.intValue());
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.nB.byteValue() == 0);
        } else if (eV == String.class) {
            return String.valueOf(this.nB);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.nB).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.nB), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
