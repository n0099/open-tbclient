package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static final ar abY = new ar();
    private final HashMap<Class<?>, Class<?>> abZ = new HashMap<>();

    public static final ar wp() {
        return abY;
    }

    private ar() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.abZ.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.abZ.containsKey(cls)) {
            this.abZ.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int wq() {
        return this.abZ.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.abZ != null) {
            return this.abZ.get(cls);
        }
        return null;
    }
}
