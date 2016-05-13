package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static final ar Xy = new ar();
    private final HashMap<Class<?>, Class<?>> Xz = new HashMap<>();

    public static final ar tX() {
        return Xy;
    }

    private ar() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.Xz.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.Xz.containsKey(cls)) {
            this.Xz.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int tY() {
        return this.Xz.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.Xz != null) {
            return this.Xz.get(cls);
        }
        return null;
    }
}
