package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aXc = new ah();
    private final HashMap<Class<?>, Class<?>> aXd = new HashMap<>();

    public static final ah CW() {
        return aXc;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aXd.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aXd.containsKey(cls)) {
            this.aXd.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int CX() {
        return this.aXd.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aXd != null) {
            return this.aXd.get(cls);
        }
        return null;
    }
}
