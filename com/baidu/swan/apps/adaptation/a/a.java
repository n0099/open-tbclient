package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes8.dex */
public abstract class a {
    public abstract void eI(boolean z);

    public void eJ(boolean z) {
        com.baidu.swan.apps.storage.c.h.aMk().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean ail() {
        return com.baidu.swan.apps.storage.c.h.aMk().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ai.a aVar) {
    }

    public void Q(Object obj) {
    }

    public Resources aim() {
        return null;
    }

    public void eK(boolean z) {
    }
}
