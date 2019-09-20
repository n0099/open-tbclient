package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ah {
    private static final ah bTJ = new ah();
    private final HashMap<Class<?>, Class<?>> bTK = new HashMap<>();

    public static final ah ajh() {
        return bTJ;
    }

    private ah() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.bTK.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.bTK.containsKey(cls)) {
            this.bTK.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int aji() {
        return this.bTK.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.bTK != null) {
            return this.bTK.get(cls);
        }
        return null;
    }
}
