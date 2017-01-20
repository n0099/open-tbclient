package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class an {
    private static final an aaC = new an();
    private final HashMap<Class<?>, Class<?>> aaD = new HashMap<>();

    public static final an uY() {
        return aaC;
    }

    private an() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aaD.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aaD.containsKey(cls)) {
            this.aaD.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int uZ() {
        return this.aaD.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aaD != null) {
            return this.aaD.get(cls);
        }
        return null;
    }
}
