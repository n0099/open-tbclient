package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ao {
    private static final ao agi = new ao();
    private final HashMap<Class<?>, Class<?>> agj = new HashMap<>();

    public static final ao vS() {
        return agi;
    }

    private ao() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.agj.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.agj.containsKey(cls)) {
            this.agj.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vT() {
        return this.agj.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.agj != null) {
            return this.agj.get(cls);
        }
        return null;
    }
}
