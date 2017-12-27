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
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
