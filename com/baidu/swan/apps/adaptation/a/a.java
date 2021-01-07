package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes9.dex */
public abstract class a {
    public abstract void eK(boolean z);

    public void eL(boolean z) {
        com.baidu.swan.apps.storage.c.h.aPI().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean alE() {
        return com.baidu.swan.apps.storage.c.h.aPI().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ai.a aVar) {
    }

    public void O(Object obj) {
    }

    public Resources alF() {
        return null;
    }

    public void eM(boolean z) {
    }
}
