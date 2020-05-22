package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes11.dex */
public abstract class a {
    public abstract void dd(boolean z);

    public void setNightModeSwitcherState(boolean z) {
        com.baidu.swan.apps.storage.c.h.arO().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean getNightModeSwitcherState() {
        return com.baidu.swan.apps.storage.c.h.arO().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ak.a aVar) {
    }

    public void unsubscribeNightModeChangedEvent(Object obj) {
    }

    public Resources getSkinResources() {
        return null;
    }

    public void de(boolean z) {
    }
}
