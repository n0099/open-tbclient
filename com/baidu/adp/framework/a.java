package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a vQ;
    private SparseArray<String> vR;

    public static a gj() {
        if (vQ == null) {
            synchronized (a.class) {
                if (vQ == null) {
                    vQ = new a();
                }
            }
        }
        return vQ;
    }

    private a() {
        this.vR = null;
        this.vR = new SparseArray<>();
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
                    if (this.vR.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.vR.get(i) + " 重复");
                    }
                    this.vR.put(i, name);
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
        String str = this.vR.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
