package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a pN;
    private SparseArray<String> pO;

    public static a cA() {
        if (pN == null) {
            synchronized (a.class) {
                if (pN == null) {
                    pN = new a();
                }
            }
        }
        return pN;
    }

    private a() {
        this.pO = null;
        this.pO = new SparseArray<>();
    }

    public void e(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                G(str);
            }
        }
    }

    private void G(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.pO.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.pO.get(i) + " 重复");
                    }
                    this.pO.put(i, name);
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

    public String J(int i) {
        String str = this.pO.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
