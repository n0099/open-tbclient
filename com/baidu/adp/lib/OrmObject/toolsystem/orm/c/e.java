package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rE;

    public e(char c) {
        this.rE = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf((byte) this.rE);
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf((short) this.rE);
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.rE);
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.rE);
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.rE);
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.rE);
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf(this.rE);
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rE) == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.rE);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.rE).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rE), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
