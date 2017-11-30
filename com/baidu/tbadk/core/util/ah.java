package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah ahn = new ah();
    private final HashMap<Class<?>, Class<?>> aho = new HashMap<>();

    public static final ah vn() {
        return ahn;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aho.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aho.containsKey(cls)) {
            this.aho.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vo() {
        return this.aho.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aho != null) {
            return this.aho.get(cls);
        }
        return null;
    }
}
