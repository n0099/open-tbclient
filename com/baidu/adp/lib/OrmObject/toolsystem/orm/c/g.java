package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float ul;

    public g(float f) {
        this.ul = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.ul.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.ul.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.ul.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.ul.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.ul.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.ul.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.ul.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.ul.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.ul);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.ul).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ul), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
