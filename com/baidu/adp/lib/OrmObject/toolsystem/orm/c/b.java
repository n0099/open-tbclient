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
        Class<?> eh = cVar.eh();
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (eh == String.class) {
            return String.valueOf(this.value);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (eh == byte[].class) {
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
