package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah ahh = new ah();
    private final HashMap<Class<?>, Class<?>> ahi = new HashMap<>();

    public static final ah vk() {
        return ahh;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ahi.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ahi.containsKey(cls)) {
            this.ahi.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vl() {
        return this.ahi.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ahi != null) {
            return this.ahi.get(cls);
        }
        return null;
    }
}
