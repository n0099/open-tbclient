package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean IX;

    public b(boolean z) {
        this.IX = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.IX);
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf((short) (this.IX ? 0 : 1));
        } else if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.IX ? 0 : 1);
        } else if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.IX ? 0 : 1);
        } else if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.IX ? 0 : 1);
        } else if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.IX ? 0 : 1);
        } else if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) (this.IX ? 0 : 1));
        } else if (fieldClass == String.class) {
            return String.valueOf(this.IX);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.IX).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.IX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
