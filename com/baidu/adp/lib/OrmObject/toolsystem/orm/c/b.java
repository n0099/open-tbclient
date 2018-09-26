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
        Class<?> hL = cVar.hL();
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (hL == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hL == byte[].class) {
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
