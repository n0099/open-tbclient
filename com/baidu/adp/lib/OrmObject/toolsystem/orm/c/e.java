package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char si;

    public e(char c) {
        this.si = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf((byte) this.si);
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf((short) this.si);
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.si);
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.si);
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.si);
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.si);
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf(this.si);
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.si) == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.si);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.si).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.si), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
