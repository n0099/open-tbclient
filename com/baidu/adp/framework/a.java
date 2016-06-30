package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a dX;
    private SparseArray<String> dY;

    public static a am() {
        if (dX == null) {
            synchronized (a.class) {
                if (dX == null) {
                    dX = new a();
                }
            }
        }
        return dX;
    }

    private a() {
        this.dY = null;
        this.dY = new SparseArray<>();
    }

    public void c(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                u(str);
            }
        }
    }

    private void u(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.dY.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.dY.get(i) + " 重复");
                    }
                    this.dY.put(i, name);
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

    public String r(int i) {
        String str = this.dY.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
