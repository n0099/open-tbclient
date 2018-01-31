package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float agv;

    public g(float f) {
        this.agv = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lL = cVar.lL();
        if (lL == Byte.class || lL == Byte.TYPE) {
            return Byte.valueOf(this.agv.byteValue());
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf(this.agv.shortValue());
        }
        if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.agv.intValue());
        }
        if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.agv.longValue());
        }
        if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.agv.floatValue());
        }
        if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.agv.doubleValue());
        }
        if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf((char) this.agv.intValue());
        }
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(this.agv.byteValue() == 0);
        } else if (lL == String.class) {
            return String.valueOf(this.agv);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.agv).toCharArray();
            }
            if (lL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agv), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
