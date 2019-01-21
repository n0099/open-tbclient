package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aCt = new ah();
    private final HashMap<Class<?>, Class<?>> aCu = new HashMap<>();

    public static final ah DT() {
        return aCt;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aCu.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aCu.containsKey(cls)) {
            this.aCu.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int DU() {
        return this.aCu.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aCu != null) {
            return this.aCu.get(cls);
        }
        return null;
    }
}
