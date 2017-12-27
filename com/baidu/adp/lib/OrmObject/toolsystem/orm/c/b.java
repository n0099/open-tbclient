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
        Class<?> lK = cVar.lK();
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (lK == String.class) {
            return String.valueOf(this.value);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (lK == byte[].class) {
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
