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
        Class<?> hb = cVar.hb();
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (hb == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hb == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hb == byte[].class) {
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
