package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a acc;
    private SparseArray<String> acd;

    public static a jU() {
        if (acc == null) {
            synchronized (a.class) {
                if (acc == null) {
                    acc = new a();
                }
            }
        }
        return acc;
    }

    private a() {
        this.acd = null;
        this.acd = new SparseArray<>();
    }

    public void o(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                H(str);
            }
        }
    }

    private void H(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.acd.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.acd.get(i) + " 重复");
                    }
                    this.acd.put(i, name);
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

    public String cz(int i) {
        String str = this.acd.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
