package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static final at XQ = new at();
    private final HashMap<Class<?>, Class<?>> XR = new HashMap<>();

    public static final at tW() {
        return XQ;
    }

    private at() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.XR.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.XR.containsKey(cls)) {
            this.XR.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int tX() {
        return this.XR.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.XR != null) {
            return this.XR.get(cls);
        }
        return null;
    }
}
