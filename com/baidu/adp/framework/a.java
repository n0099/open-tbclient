package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: tv  reason: collision with root package name */
    private static volatile a f3tv;
    private SparseArray<String> tw;

    public static a fb() {
        if (f3tv == null) {
            synchronized (a.class) {
                if (f3tv == null) {
                    f3tv = new a();
                }
            }
        }
        return f3tv;
    }

    private a() {
        this.tw = null;
        this.tw = new SparseArray<>();
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
                    if (this.tw.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.tw.get(i) + " 重复");
                    }
                    this.tw.put(i, name);
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
        String str = this.tw.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
