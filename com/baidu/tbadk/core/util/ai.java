package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ai {
    private static final ai aqt = new ai();
    private final HashMap<Class<?>, Class<?>> aqu = new HashMap<>();

    public static final ai zl() {
        return aqt;
    }

    private ai() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aqu.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aqu.containsKey(cls)) {
            this.aqu.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int zm() {
        return this.aqu.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aqu != null) {
            return this.aqu.get(cls);
        }
        return null;
    }
}
