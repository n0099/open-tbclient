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
        Class<?> ek = cVar.ek();
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.value ? (short) 0 : (short) 1);
        } else if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.value ? (short) 0 : (short) 1);
        } else if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.value ? (short) 0 : (short) 1);
        } else if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.value ? (short) 0 : (short) 1);
        } else if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.value ? (short) 0 : (short) 1);
        } else if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) (this.value ? (short) 0 : (short) 1));
        } else if (ek == String.class) {
            return String.valueOf(this.value);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (ek == byte[].class) {
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
