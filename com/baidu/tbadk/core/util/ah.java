package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah ahk = new ah();
    private final HashMap<Class<?>, Class<?>> ahl = new HashMap<>();

    public static final ah vG() {
        return ahk;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ahl.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ahl.containsKey(cls)) {
            this.ahl.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vH() {
        return this.ahl.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ahl != null) {
            return this.ahl.get(cls);
        }
        return null;
    }
}
