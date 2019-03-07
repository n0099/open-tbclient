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
        Class<?> hY = cVar.hY();
        if (hY == Boolean.class || hY == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (hY == Short.class || hY == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (hY == Integer.class || hY == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (hY == Long.class || hY == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (hY == Float.class || hY == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (hY == Double.class || hY == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (hY == Character.class || hY == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (hY == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hY == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hY == byte[].class) {
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
