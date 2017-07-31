package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ag {
    private static final ag ahO = new ag();
    private final HashMap<Class<?>, Class<?>> ahP = new HashMap<>();

    public static final ag vI() {
        return ahO;
    }

    private ag() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ahP.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ahP.containsKey(cls)) {
            this.ahP.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vJ() {
        return this.ahP.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ahP != null) {
            return this.ahP.get(cls);
        }
        return null;
    }
}
