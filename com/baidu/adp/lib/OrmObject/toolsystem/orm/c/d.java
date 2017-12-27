package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte agq;

    public d(byte b) {
        this.agq = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(this.agq.byteValue());
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(this.agq.shortValue());
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.agq.intValue());
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.agq.longValue());
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.agq.floatValue());
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.agq.doubleValue());
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) this.agq.intValue());
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.agq.byteValue() == 0);
        } else if (lK == String.class) {
            return String.valueOf(this.agq);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.agq).toCharArray();
            }
            if (lK == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agq), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
