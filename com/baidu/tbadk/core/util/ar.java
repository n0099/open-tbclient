package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static final ar abZ = new ar();
    private final HashMap<Class<?>, Class<?>> aca = new HashMap<>();

    public static final ar vu() {
        return abZ;
    }

    private ar() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aca.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aca.containsKey(cls)) {
            this.aca.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vv() {
        return this.aca.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aca != null) {
            return this.aca.get(cls);
        }
        return null;
    }
}
