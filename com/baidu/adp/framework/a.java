package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a nx;
    private SparseArray<String> ny;

    public static a cp() {
        if (nx == null) {
            synchronized (a.class) {
                if (nx == null) {
                    nx = new a();
                }
            }
        }
        return nx;
    }

    private a() {
        this.ny = null;
        this.ny = new SparseArray<>();
    }

    public void e(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                A(str);
            }
        }
    }

    private void A(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.ny.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.ny.get(i) + " 重复");
                    }
                    this.ny.put(i, name);
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

    public String G(int i) {
        String str = this.ny.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
