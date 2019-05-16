package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bSb = new ah();
    private final HashMap<Class<?>, Class<?>> bSc = new HashMap<>();

    public static final ah ahZ() {
        return bSb;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bSc.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bSc.containsKey(cls)) {
            this.bSc.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int aia() {
        return this.bSc.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bSc != null) {
            return this.bSc.get(cls);
        }
        return null;
    }
}
