package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a gN;
    private SparseArray<String> gO;

    public static a bh() {
        if (gN == null) {
            synchronized (a.class) {
                if (gN == null) {
                    gN = new a();
                }
            }
        }
        return gN;
    }

    private a() {
        this.gO = null;
        this.gO = new SparseArray<>();
    }

    public void c(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                z(str);
            }
        }
    }

    private void z(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.gO.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.gO.get(i) + " 重复");
                    }
                    this.gO.put(i, name);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        }
    }

    public String H(int i) {
        String str = this.gO.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
