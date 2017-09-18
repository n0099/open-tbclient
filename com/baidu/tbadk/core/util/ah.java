package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah ahj = new ah();
    private final HashMap<Class<?>, Class<?>> ahk = new HashMap<>();

    public static final ah vG() {
        return ahj;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.ahk.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.ahk.containsKey(cls)) {
            this.ahk.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vH() {
        return this.ahk.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.ahk != null) {
            return this.ahk.get(cls);
        }
        return null;
    }
}
