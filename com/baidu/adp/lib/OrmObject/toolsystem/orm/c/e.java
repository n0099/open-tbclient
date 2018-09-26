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
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
