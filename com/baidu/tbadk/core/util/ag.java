package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ag {
    private static final ag ahQ = new ag();
    private final HashMap<Class<?>, Class<?>> ahR = new HashMap<>();

    public static final ag vI() {
        return ahQ;
    }

    private ag() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ahR.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ahR.containsKey(cls)) {
            this.ahR.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vJ() {
        return this.ahR.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ahR != null) {
            return this.ahR.get(cls);
        }
        return null;
    }
}
