package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes8.dex */
public abstract class a {
    public abstract void dt(boolean z);

    public void setNightModeSwitcherState(boolean z) {
        com.baidu.swan.apps.storage.c.h.aDf().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean getNightModeSwitcherState() {
        return com.baidu.swan.apps.storage.c.h.aDf().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.aj.a aVar) {
    }

    public void unsubscribeNightModeChangedEvent(Object obj) {
    }

    public Resources getSkinResources() {
        return null;
    }

    public void du(boolean z) {
    }
}
