package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char tS;

    public e(char c) {
        this.tS = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf((byte) this.tS);
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf((short) this.tS);
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.tS);
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.tS);
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.tS);
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.tS);
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf(this.tS);
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.tS) == 0);
        } else if (es == String.class) {
            return String.valueOf(this.tS);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.tS).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.tS), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
