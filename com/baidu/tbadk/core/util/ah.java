package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aVw = new ah();
    private final HashMap<Class<?>, Class<?>> aVx = new HashMap<>();

    public static final ah CD() {
        return aVw;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aVx.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aVx.containsKey(cls)) {
            this.aVx.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CE() {
        return this.aVx.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aVx != null) {
            return this.aVx.get(cls);
        }
        return null;
    }
}
