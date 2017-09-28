package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean value;

    public b(boolean z) {
        this.value = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (eg == String.class) {
            return String.valueOf(this.value);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
