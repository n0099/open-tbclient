package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aq {
    private static final aq acp = new aq();
    private final HashMap<Class<?>, Class<?>> acq = new HashMap<>();

    public static final aq uR() {
        return acp;
    }

    private aq() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.acq.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.acq.containsKey(cls)) {
            this.acq.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int uS() {
        return this.acq.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.acq != null) {
            return this.acq.get(cls);
        }
        return null;
    }
}
