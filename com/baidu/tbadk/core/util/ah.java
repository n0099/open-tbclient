package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bTc = new ah();
    private final HashMap<Class<?>, Class<?>> bTd = new HashMap<>();

    public static final ah ajb() {
        return bTc;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bTd.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bTd.containsKey(cls)) {
            this.bTd.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int ajc() {
        return this.bTd.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bTd != null) {
            return this.bTd.get(cls);
        }
        return null;
    }
}
