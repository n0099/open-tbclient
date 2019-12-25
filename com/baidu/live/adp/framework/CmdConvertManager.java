package com.baidu.live.adp.framework;

import android.util.SparseArray;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes2.dex */
public class CmdConvertManager {
    private static volatile CmdConvertManager sInstance;
    private SparseArray<String> mCmdMap;

    public static CmdConvertManager getInstance() {
        if (sInstance == null) {
            synchronized (CmdConvertManager.class) {
                if (sInstance == null) {
                    sInstance = new CmdConvertManager();
                }
            }
        }
        return sInstance;
    }

    private CmdConvertManager() {
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
