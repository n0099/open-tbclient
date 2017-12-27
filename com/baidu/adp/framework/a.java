package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a ack;
    private SparseArray<String> acl;

    public static a jU() {
        if (ack == null) {
            synchronized (a.class) {
                if (ack == null) {
                    ack = new a();
                }
            }
        }
        return ack;
    }

    private a() {
        this.acl = null;
        this.acl = new SparseArray<>();
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
                    if (this.acl.get(i) != null) {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.acl.get(i) + " 重复");
                    }
                    this.acl.put(i, name);
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
        String str = this.acl.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
