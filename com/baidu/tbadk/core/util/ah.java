package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bSc = new ah();
    private final HashMap<Class<?>, Class<?>> bSd = new HashMap<>();

    public static final ah ahZ() {
        return bSc;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bSd.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bSd.containsKey(cls)) {
            this.bSd.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int aia() {
        return this.bSd.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bSd != null) {
            return this.bSd.get(cls);
        }
        return null;
    }
}
