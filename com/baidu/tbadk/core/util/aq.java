package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aq {
    private static final aq abL = new aq();
    private final HashMap<Class<?>, Class<?>> abM = new HashMap<>();

    public static final aq vh() {
        return abL;
    }

    private aq() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.abM.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.abM.containsKey(cls)) {
            this.abM.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vi() {
        return this.abM.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.abM != null) {
            return this.abM.get(cls);
        }
        return null;
    }
}
