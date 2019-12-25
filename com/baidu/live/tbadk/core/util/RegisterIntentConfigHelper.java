package com.baidu.live.tbadk.core.util;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class RegisterIntentConfigHelper {
    private static final RegisterIntentConfigHelper inst = new RegisterIntentConfigHelper();
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();

    public static final RegisterIntentConfigHelper getInst() {
        return inst;
    }

    private RegisterIntentConfigHelper() {
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

    public int getConfigSize() {
        return this.mActicyConfig.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.mActicyConfig != null) {
            return this.mActicyConfig.get(cls);
        }
        return null;
    }
}
