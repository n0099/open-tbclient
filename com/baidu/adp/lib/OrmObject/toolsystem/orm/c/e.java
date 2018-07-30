package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char value;

    public e(char c) {
        this.value = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
