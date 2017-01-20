package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float lg;

    public g(float f) {
        this.lg = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> db = cVar.db();
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(this.lg.byteValue());
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.lg.shortValue());
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.lg.intValue());
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.lg.longValue());
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.lg.floatValue());
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.lg.doubleValue());
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) this.lg.intValue());
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.lg.byteValue() == 0);
        } else if (db == String.class) {
            return String.valueOf(this.lg);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.lg).toCharArray();
            }
            if (db == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lg), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
