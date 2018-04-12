package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a mq;
    private SparseArray<String> mr;

    public static a bY() {
        if (mq == null) {
            synchronized (a.class) {
                if (mq == null) {
                    mq = new a();
                }
            }
        }
        return mq;
    }

    private a() {
        this.mr = null;
        this.mr = new SparseArray<>();
    }

    public void f(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                E(str);
            }
        }
    }

    private void E(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.mr.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.mr.get(i) + " 重复");
                    }
                    this.mr.put(i, name);
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

    public String z(int i) {
        String str = this.mr.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
