package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah agH = new ah();
    private final HashMap<Class<?>, Class<?>> agI = new HashMap<>();

    public static final ah vk() {
        return agH;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.agI.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.agI.containsKey(cls)) {
            this.agI.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vl() {
        return this.agI.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.agI != null) {
            return this.agI.get(cls);
        }
        return null;
    }
}
