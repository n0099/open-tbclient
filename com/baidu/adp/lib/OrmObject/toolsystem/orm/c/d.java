package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte le;

    public d(byte b) {
        this.le = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> db = cVar.db();
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(this.le.byteValue());
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.le.shortValue());
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.le.intValue());
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.le.longValue());
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.le.floatValue());
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.le.doubleValue());
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) this.le.intValue());
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.le.byteValue() == 0);
        } else if (db == String.class) {
            return String.valueOf(this.le);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.le).toCharArray();
            }
            if (db == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.le), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
