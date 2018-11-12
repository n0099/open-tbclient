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
        Class<?> hZ = cVar.hZ();
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (hZ == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hZ == byte[].class) {
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
