package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aVt = new ah();
    private final HashMap<Class<?>, Class<?>> aVu = new HashMap<>();

    public static final ah CC() {
        return aVt;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aVu.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aVu.containsKey(cls)) {
            this.aVu.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CD() {
        return this.aVu.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aVu != null) {
            return this.aVu.get(cls);
        }
        return null;
    }
}
