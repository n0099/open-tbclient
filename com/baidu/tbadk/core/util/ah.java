package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah ayq = new ah();
    private final HashMap<Class<?>, Class<?>> ayr = new HashMap<>();

    public static final ah CC() {
        return ayq;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ayr.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ayr.containsKey(cls)) {
            this.ayr.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CD() {
        return this.ayr.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ayr != null) {
            return this.ayr.get(cls);
        }
        return null;
    }
}
