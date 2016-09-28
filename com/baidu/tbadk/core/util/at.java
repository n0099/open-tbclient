package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static final at abB = new at();
    private final HashMap<Class<?>, Class<?>> abC = new HashMap<>();

    public static final at vq() {
        return abB;
    }

    private at() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.abC.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.abC.containsKey(cls)) {
            this.abC.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vr() {
        return this.abC.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.abC != null) {
            return this.abC.get(cls);
        }
        return null;
    }
}
