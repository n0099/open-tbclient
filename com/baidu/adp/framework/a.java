package com.baidu.adp.framework;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a la;
    private SparseArray<String> mCmdMap;

    public static a eu() {
        if (la == null) {
            synchronized (a.class) {
                if (la == null) {
                    la = new a();
                }
            }
        }
        return la;
    }

    private a() {
        this.mCmdMap = null;
        this.mCmdMap = new SparseArray<>();
    }

    public void init(List<String> list) {
        if (BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                loadField(str);
            }
        }
    }

    private void loadField(String str) {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    int i = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.mCmdMap.get(i) != null) {
                        throw new Error("cmd " + str + HanziToPinyin.Token.SEPARATOR + name + " 和 " + this.mCmdMap.get(i) + " 重复");
                    }
                    this.mCmdMap.put(i, name);
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

    public String getNameByCmd(int i) {
        String str = this.mCmdMap.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }
}
