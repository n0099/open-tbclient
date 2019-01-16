package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aCs = new ah();
    private final HashMap<Class<?>, Class<?>> aCt = new HashMap<>();

    public static final ah DT() {
        return aCs;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aCt.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aCt.containsKey(cls)) {
            this.aCt.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int DU() {
        return this.aCt.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aCt != null) {
            return this.aCt.get(cls);
        }
        return null;
    }
}
