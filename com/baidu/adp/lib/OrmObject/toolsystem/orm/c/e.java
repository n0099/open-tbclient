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
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.value);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (gS == byte[].class) {
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
