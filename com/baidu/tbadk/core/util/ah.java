package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah agQ = new ah();
    private final HashMap<Class<?>, Class<?>> agR = new HashMap<>();

    public static final ah vk() {
        return agQ;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.agR.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.agR.containsKey(cls)) {
            this.agR.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vl() {
        return this.agR.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.agR != null) {
            return this.agR.get(cls);
        }
        return null;
    }
}
