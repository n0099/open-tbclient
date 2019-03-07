package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bKn = new ah();
    private final HashMap<Class<?>, Class<?>> bKo = new HashMap<>();

    public static final ah ade() {
        return bKn;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bKo.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bKo.containsKey(cls)) {
            this.bKo.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int adf() {
        return this.bKo.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bKo != null) {
            return this.bKo.get(cls);
        }
        return null;
    }
}
