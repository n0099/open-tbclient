package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double lf;

    public f(double d) {
        this.lf = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> db = cVar.db();
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(this.lf.byteValue());
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.lf.shortValue());
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.lf.intValue());
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.lf.longValue());
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.lf.floatValue());
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.lf.doubleValue());
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) this.lf.intValue());
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.lf.byteValue() == 0);
        } else if (db == String.class) {
            return String.valueOf(this.lf);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.lf).toCharArray();
            }
            if (db == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lf), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
