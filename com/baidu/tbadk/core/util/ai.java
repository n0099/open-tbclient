package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ai {
    private static final ai aqS = new ai();
    private final HashMap<Class<?>, Class<?>> aqT = new HashMap<>();

    public static final ai zu() {
        return aqS;
    }

    private ai() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aqT.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aqT.containsKey(cls)) {
            this.aqT.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int zv() {
        return this.aqT.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aqT != null) {
            return this.aqT.get(cls);
        }
        return null;
    }
}
