package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short ll;

    public s(short s) {
        this.ll = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> db = cVar.db();
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(this.ll.byteValue());
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.ll.shortValue());
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.ll.intValue());
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.ll.longValue());
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.ll.floatValue());
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.ll.doubleValue());
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) this.ll.intValue());
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.ll.byteValue() == 0);
        } else if (db == String.class) {
            return String.valueOf(this.ll);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.ll).toCharArray();
            }
            if (db == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ll), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
