package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class al {
    private static final al aaY = new al();
    private final HashMap<Class<?>, Class<?>> aaZ = new HashMap<>();

    public static final al uB() {
        return aaY;
    }

    private al() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aaZ.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aaZ.containsKey(cls)) {
            this.aaZ.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int uC() {
        return this.aaZ.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aaZ != null) {
            return this.aaZ.get(cls);
        }
        return null;
    }
}
