package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aVu = new ah();
    private final HashMap<Class<?>, Class<?>> aVv = new HashMap<>();

    public static final ah CK() {
        return aVu;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aVv.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aVv.containsKey(cls)) {
            this.aVv.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CL() {
        return this.aVv.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aVv != null) {
            return this.aVv.get(cls);
        }
        return null;
    }
}
