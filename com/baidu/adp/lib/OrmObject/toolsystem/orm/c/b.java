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
        Class<?> gF = cVar.gF();
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (gF == String.class) {
            return String.valueOf(this.value);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (gF == byte[].class) {
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
