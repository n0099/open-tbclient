package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class RegisterIntentConfigHelper {
    public static final RegisterIntentConfigHelper inst = new RegisterIntentConfigHelper();
    public final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();

    public static final RegisterIntentConfigHelper getInst() {
        return inst;
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.mActicyConfig.containsKey(cls)) {
            logStaticRegister(cls, cls2);
            this.mActicyConfig.put(cls, cls2);
            return;
        }
        BdLog.e("register Intent failed, " + cls.getName() + " exist");
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        logStaticRegister(cls, cls2);
        this.mActicyConfig.put(cls, cls2);
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int getConfigSize() {
        return this.mActicyConfig.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        HashMap<Class<?>, Class<?>> hashMap = this.mActicyConfig;
        if (hashMap != null) {
            return hashMap.get(cls);
        }
        return null;
    }

    public void logStaticRegister(Class<?> cls, Class<?> cls2) {
    }
}
