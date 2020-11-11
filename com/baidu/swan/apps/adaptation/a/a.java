package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes10.dex */
public abstract class a {
    public abstract void ek(boolean z);

    public void setNightModeSwitcherState(boolean z) {
        com.baidu.swan.apps.storage.c.h.aKS().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean getNightModeSwitcherState() {
        return com.baidu.swan.apps.storage.c.h.aKS().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.aj.a aVar) {
    }

    public void unsubscribeNightModeChangedEvent(Object obj) {
    }

    public Resources getSkinResources() {
        return null;
    }

    public void el(boolean z) {
    }
}
