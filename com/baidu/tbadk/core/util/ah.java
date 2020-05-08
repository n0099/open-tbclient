package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah dzy = new ah();
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();

    public static final ah aOG() {
        return dzy;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        d(cls, cls2);
        this.mActicyConfig.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.mActicyConfig.containsKey(cls)) {
            d(cls, cls2);
            this.mActicyConfig.put(cls, cls2);
            return;
        }
        BdLog.e("register Intent failed, " + cls.getName() + " exist");
    }

    public void d(Class<?> cls, Class<?> cls2) {
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int getConfigSize() {
        return this.mActicyConfig.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.mActicyConfig != null) {
            return this.mActicyConfig.get(cls);
        }
        return null;
    }
}
