package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a sF;
    private SparseArray<String> sG;

    public static a eL() {
        if (sF == null) {
            synchronized (a.class) {
                if (sF == null) {
                    sF = new a();
                }
            }
        }
        return sF;
    }

    private a() {
        this.sG = null;
        this.sG = new SparseArray<>();
    }

    public void i(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                Q(str);
            }
        }
    }

    private void Q(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.sG.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.sG.get(i) + " 重复");
                    }
                    this.sG.put(i, name);
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

    public String A(int i) {
        String str = this.sG.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
