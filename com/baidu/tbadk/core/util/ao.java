package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ao {
    private static final ao agh = new ao();
    private final HashMap<Class<?>, Class<?>> agi = new HashMap<>();

    public static final ao vS() {
        return agh;
    }

    private ao() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.agi.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.agi.containsKey(cls)) {
            this.agi.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vT() {
        return this.agi.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.agi != null) {
            return this.agi.get(cls);
        }
        return null;
    }
}
