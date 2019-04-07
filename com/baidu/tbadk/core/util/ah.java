package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bKq = new ah();
    private final HashMap<Class<?>, Class<?>> bKr = new HashMap<>();

    public static final ah adb() {
        return bKq;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bKr.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bKr.containsKey(cls)) {
            this.bKr.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int adc() {
        return this.bKr.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bKr != null) {
            return this.bKr.get(cls);
        }
        return null;
    }
}
