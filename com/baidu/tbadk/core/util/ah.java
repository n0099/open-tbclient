package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah axD = new ah();
    private final HashMap<Class<?>, Class<?>> axE = new HashMap<>();

    public static final ah Cv() {
        return axD;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.axE.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.axE.containsKey(cls)) {
            this.axE.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int Cw() {
        return this.axE.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.axE != null) {
            return this.axE.get(cls);
        }
        return null;
    }
}
