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
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.value);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (ia == byte[].class) {
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
