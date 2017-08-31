package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rD;

    public e(char c) {
        this.rD = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf((byte) this.rD);
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf((short) this.rD);
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.rD);
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.rD);
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.rD);
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.rD);
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf(this.rD);
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rD) == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.rD);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.rD).toCharArray();
            }
            if (eh == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rD), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
