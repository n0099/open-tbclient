package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah agv = new ah();
    private final HashMap<Class<?>, Class<?>> agw = new HashMap<>();

    public static final ah vd() {
        return agv;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.agw.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.agw.containsKey(cls)) {
            this.agw.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int ve() {
        return this.agw.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.agw != null) {
            return this.agw.get(cls);
        }
        return null;
    }
}
