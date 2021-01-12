package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes8.dex */
public abstract class a {
    public abstract void eG(boolean z);

    public void eH(boolean z) {
        com.baidu.swan.apps.storage.c.h.aLO().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean ahK() {
        return com.baidu.swan.apps.storage.c.h.aLO().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ai.a aVar) {
    }

    public void O(Object obj) {
    }

    public Resources ahL() {
        return null;
    }

    public void eI(boolean z) {
    }
}
