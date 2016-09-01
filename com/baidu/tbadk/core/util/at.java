package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static final at abn = new at();
    private final HashMap<Class<?>, Class<?>> abo = new HashMap<>();

    public static final at vb() {
        return abn;
    }

    private at() {
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.abo.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.abo.containsKey(cls)) {
            this.abo.put(cls, cls2);
        } else {
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public int vc() {
        return this.abo.size();
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.abo != null) {
            return this.abo.get(cls);
        }
        return null;
    }
}
