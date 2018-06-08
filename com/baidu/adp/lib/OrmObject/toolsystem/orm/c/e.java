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
        Class<?> gG = cVar.gG();
        if (gG == Byte.class || gG == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
