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
        Class<?> lL = cVar.lL();
        if (lL == Byte.class || lL == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (lL == String.class) {
            return String.valueOf(this.value);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (lL == byte[].class) {
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
