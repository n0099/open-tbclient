package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean kK;

    public b(boolean z) {
        this.kK = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> db = cVar.db();
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.kK);
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.kK ? (short) 0 : (short) 1);
        } else if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.kK ? (short) 0 : (short) 1);
        } else if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.kK ? (short) 0 : (short) 1);
        } else if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.kK ? (short) 0 : (short) 1);
        } else if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.kK ? (short) 0 : (short) 1);
        } else if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) (this.kK ? (short) 0 : (short) 1));
        } else if (db == String.class) {
            return String.valueOf(this.kK);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.kK).toCharArray();
            }
            if (db == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.kK), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
