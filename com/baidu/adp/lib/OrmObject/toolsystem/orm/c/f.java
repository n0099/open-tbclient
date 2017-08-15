package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double uk;

    public f(double d) {
        this.uk = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.uk.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.uk.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.uk.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.uk.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.uk.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.uk.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.uk.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.uk.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.uk);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.uk).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.uk), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
