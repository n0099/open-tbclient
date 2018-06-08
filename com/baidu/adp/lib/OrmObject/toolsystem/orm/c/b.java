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
        Class<?> gG = cVar.gG();
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (gG == String.class) {
            return String.valueOf(this.value);
        } else {
            if (gG == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (gG == byte[].class) {
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
