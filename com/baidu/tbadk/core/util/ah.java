package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aWQ = new ah();
    private final HashMap<Class<?>, Class<?>> aWR = new HashMap<>();

    public static final ah CV() {
        return aWQ;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aWR.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aWR.containsKey(cls)) {
            this.aWR.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CW() {
        return this.aWR.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aWR != null) {
            return this.aWR.get(cls);
        }
        return null;
    }
}
