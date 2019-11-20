package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean mD;

    public b(boolean z) {
        this.mD = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.mD);
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf((short) (this.mD ? 0 : 1));
        } else if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.mD ? 0 : 1);
        } else if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.mD ? 0 : 1);
        } else if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.mD ? 0 : 1);
        } else if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.mD ? 0 : 1);
        } else if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) (this.mD ? 0 : 1));
        } else if (eV == String.class) {
            return String.valueOf(this.mD);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.mD).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.mD), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
