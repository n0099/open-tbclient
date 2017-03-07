package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char sI;

    public e(char c) {
        this.sI = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf((byte) this.sI);
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf((short) this.sI);
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.sI);
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.sI);
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.sI);
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.sI);
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf(this.sI);
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.sI) == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.sI);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.sI).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
