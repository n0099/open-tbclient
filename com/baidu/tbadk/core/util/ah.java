package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah aBQ = new ah();
    private final HashMap<Class<?>, Class<?>> aBR = new HashMap<>();

    public static final ah DG() {
        return aBQ;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.aBR.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.aBR.containsKey(cls)) {
            this.aBR.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int DH() {
        return this.aBR.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.aBR != null) {
            return this.aBR.get(cls);
        }
        return null;
    }
}
