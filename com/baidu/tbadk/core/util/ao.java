package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ao {
    private static final ao afq = new ao();
    private final HashMap<Class<?>, Class<?>> afr = new HashMap<>();

    public static final ao vd() {
        return afq;
    }

    private ao() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.afr.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.afr.containsKey(cls)) {
            this.afr.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int ve() {
        return this.afr.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.afr != null) {
            return this.afr.get(cls);
        }
        return null;
    }
}
