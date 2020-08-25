package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean JA;

    public b(boolean z) {
        this.JA = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.JA);
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf((short) (this.JA ? 0 : 1));
        } else if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.JA ? 0 : 1);
        } else if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.JA ? 0 : 1);
        } else if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.JA ? 0 : 1);
        } else if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.JA ? 0 : 1);
        } else if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) (this.JA ? 0 : 1));
        } else if (fieldClass == String.class) {
            return String.valueOf(this.JA);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.JA).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.JA), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
