package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ap {
    private static final ap abq = new ap();
    private final HashMap<Class<?>, Class<?>> abr = new HashMap<>();

    public static final ap ve() {
        return abq;
    }

    private ap() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.abr.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.abr.containsKey(cls)) {
            this.abr.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vf() {
        return this.abr.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.abr != null) {
            return this.abr.get(cls);
        }
        return null;
    }
}
