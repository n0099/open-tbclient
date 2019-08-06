package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bTi = new ah();
    private final HashMap<Class<?>, Class<?>> bTj = new HashMap<>();

    public static final ah ajd() {
        return bTi;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bTj.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bTj.containsKey(cls)) {
            this.bTj.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int aje() {
        return this.bTj.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bTj != null) {
            return this.bTj.get(cls);
        }
        return null;
    }
}
