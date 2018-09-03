package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ai {
    private static final ai aqu = new ai();
    private final HashMap<Class<?>, Class<?>> aqv = new HashMap<>();

    public static final ai zj() {
        return aqu;
    }

    private ai() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aqv.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aqv.containsKey(cls)) {
            this.aqv.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int zk() {
        return this.aqv.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aqv != null) {
            return this.aqv.get(cls);
        }
        return null;
    }
}
