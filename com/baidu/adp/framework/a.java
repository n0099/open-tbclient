package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a nz;
    private SparseArray<String> nA;

    public static a cp() {
        if (nz == null) {
            synchronized (a.class) {
                if (nz == null) {
                    nz = new a();
                }
            }
        }
        return nz;
    }

    private a() {
        this.nA = null;
        this.nA = new SparseArray<>();
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
                    if (this.nA.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.nA.get(i) + " 重复");
                    }
                    this.nA.put(i, name);
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

    public String F(int i) {
        String str = this.nA.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
