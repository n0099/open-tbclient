package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a vS;
    private SparseArray<String> vT;

    public static a gm() {
        if (vS == null) {
            synchronized (a.class) {
                if (vS == null) {
                    vS = new a();
                }
            }
        }
        return vS;
    }

    private a() {
        this.vT = null;
        this.vT = new SparseArray<>();
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
                    if (this.vT.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.vT.get(i) + " 重复");
                    }
                    this.vT.put(i, name);
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
        String str = this.vT.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
