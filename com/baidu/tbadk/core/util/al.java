package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class al {
    private static final al aaU = new al();
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();

    public static final al uy() {
        return aaU;
    }

    private al() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.mActicyConfig.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.mActicyConfig.containsKey(cls)) {
            this.mActicyConfig.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.mActicyConfig != null) {
            Class<?> cls2 = this.mActicyConfig.get(cls);
            if (cls2 == null) {
                TiebaStatic.log(new aq("inter_config_not_found").ae("name", cls == null ? "" : cls.getSimpleName()));
                return cls2;
            }
            return cls2;
        }
        return null;
    }
}
