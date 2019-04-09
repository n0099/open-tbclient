package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bKr = new ah();
    private final HashMap<Class<?>, Class<?>> bKs = new HashMap<>();

    public static final ah adb() {
        return bKr;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bKs.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bKs.containsKey(cls)) {
            this.bKs.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int adc() {
        return this.bKs.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bKs != null) {
            return this.bKs.get(cls);
        }
        return null;
    }
}
