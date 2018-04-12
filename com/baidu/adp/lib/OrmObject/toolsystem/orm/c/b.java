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
        Class<?> dP = cVar.dP();
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (dP == String.class) {
            return String.valueOf(this.value);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (dP == byte[].class) {
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
