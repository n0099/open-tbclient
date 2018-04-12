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
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
