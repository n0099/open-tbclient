package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static final at Yz = new at();
    private final HashMap<Class<?>, Class<?>> YA = new HashMap<>();

    public static final at tV() {
        return Yz;
    }

    private at() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.YA.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.YA.containsKey(cls)) {
            this.YA.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int tW() {
        return this.YA.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.YA != null) {
            return this.YA.get(cls);
        }
        return null;
    }
}
