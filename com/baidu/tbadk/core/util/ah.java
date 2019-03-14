package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bKo = new ah();
    private final HashMap<Class<?>, Class<?>> bKp = new HashMap<>();

    public static final ah ade() {
        return bKo;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bKp.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bKp.containsKey(cls)) {
            this.bKp.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int adf() {
        return this.bKp.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bKp != null) {
            return this.bKp.get(cls);
        }
        return null;
    }
}
