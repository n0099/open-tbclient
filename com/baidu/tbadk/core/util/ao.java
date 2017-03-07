package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ao {
    private static final ao afS = new ao();
    private final HashMap<Class<?>, Class<?>> afT = new HashMap<>();

    public static final ao vv() {
        return afS;
    }

    private ao() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.afT.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.afT.containsKey(cls)) {
            this.afT.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vw() {
        return this.afT.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.afT != null) {
            return this.afT.get(cls);
        }
        return null;
    }
}
