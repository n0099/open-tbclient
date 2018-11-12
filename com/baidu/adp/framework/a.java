package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a vU;
    private SparseArray<String> vV;

    public static a gm() {
        if (vU == null) {
            synchronized (a.class) {
                if (vU == null) {
                    vU = new a();
                }
            }
        }
        return vU;
    }

    private a() {
        this.vV = null;
        this.vV = new SparseArray<>();
    }

    public void i(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                ah(str);
            }
        }
    }

    private void ah(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.vV.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.vV.get(i) + " 重复");
                    }
                    this.vV.put(i, name);
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

    public String Z(int i) {
        String str = this.vV.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
