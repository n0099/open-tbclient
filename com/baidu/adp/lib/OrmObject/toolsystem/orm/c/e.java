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
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf((byte) this.si);
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf((short) this.si);
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.si);
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.si);
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.si);
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.si);
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf(this.si);
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.si) == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.si);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.si).toCharArray();
            }
            if (eh == byte[].class) {
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
