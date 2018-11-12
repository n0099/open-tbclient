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
        Class<?> hZ = cVar.hZ();
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (hZ == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hZ == byte[].class) {
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
