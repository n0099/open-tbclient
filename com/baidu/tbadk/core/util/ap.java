package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ap {
    private static final ap acL = new ap();
    private final HashMap<Class<?>, Class<?>> acM = new HashMap<>();

    public static final ap vW() {
        return acL;
    }

    private ap() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.acM.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.acM.containsKey(cls)) {
            this.acM.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vX() {
        return this.acM.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.acM != null) {
            return this.acM.get(cls);
        }
        return null;
    }
}
