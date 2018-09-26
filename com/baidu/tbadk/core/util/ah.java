package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah asS = new ah();
    private final HashMap<Class<?>, Class<?>> asT = new HashMap<>();

    public static final ah Ao() {
        return asS;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.asT.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.asT.containsKey(cls)) {
            this.asT.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int Ap() {
        return this.asT.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.asT != null) {
            return this.asT.get(cls);
        }
        return null;
    }
}
