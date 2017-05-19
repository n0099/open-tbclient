package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ao {
    private static final ao afz = new ao();
    private final HashMap<Class<?>, Class<?>> afA = new HashMap<>();

    public static final ao vg() {
        return afz;
    }

    private ao() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.afA.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.afA.containsKey(cls)) {
            this.afA.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vh() {
        return this.afA.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.afA != null) {
            return this.afA.get(cls);
        }
        return null;
    }
}
