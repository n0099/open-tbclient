package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aim = new ah();
    private final HashMap<Class<?>, Class<?>> ain = new HashMap<>();

    public static final ah vF() {
        return aim;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ain.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ain.containsKey(cls)) {
            this.ain.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vG() {
        return this.ain.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ain != null) {
            return this.ain.get(cls);
        }
        return null;
    }
}
