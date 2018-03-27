package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aWS = new ah();
    private final HashMap<Class<?>, Class<?>> aWT = new HashMap<>();

    public static final ah CW() {
        return aWS;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aWT.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aWT.containsKey(cls)) {
            this.aWT.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CX() {
        return this.aWT.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aWT != null) {
            return this.aWT.get(cls);
        }
        return null;
    }
}
