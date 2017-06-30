package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aq {
    private static final aq afY = new aq();
    private final HashMap<Class<?>, Class<?>> afZ = new HashMap<>();

    public static final aq vs() {
        return afY;
    }

    private aq() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.afZ.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.afZ.containsKey(cls)) {
            this.afZ.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vt() {
        return this.afZ.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.afZ != null) {
            return this.afZ.get(cls);
        }
        return null;
    }
}
