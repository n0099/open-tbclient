package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a oF;
    private SparseArray<String> oG;

    public static a cq() {
        if (oF == null) {
            synchronized (a.class) {
                if (oF == null) {
                    oF = new a();
                }
            }
        }
        return oF;
    }

    private a() {
        this.oG = null;
        this.oG = new SparseArray<>();
    }

    public void c(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                y(str);
            }
        }
    }

    private void y(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.oG.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.oG.get(i) + " 重复");
                    }
                    this.oG.put(i, name);
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

    public String I(int i) {
        String str = this.oG.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
