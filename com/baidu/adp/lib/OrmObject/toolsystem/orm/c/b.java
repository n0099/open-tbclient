package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean value;

    public b(boolean z) {
        this.value = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (es == String.class) {
            return String.valueOf(this.value);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
