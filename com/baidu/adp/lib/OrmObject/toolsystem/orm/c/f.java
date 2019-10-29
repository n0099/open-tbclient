package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double nw;

    public f(double d) {
        this.nw = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(this.nw.byteValue());
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(this.nw.shortValue());
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.nw.intValue());
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.nw.longValue());
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.nw.floatValue());
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.nw.doubleValue());
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) this.nw.intValue());
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.nw.byteValue() == 0);
        } else if (eV == String.class) {
            return String.valueOf(this.nw);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.nw).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.nw), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
