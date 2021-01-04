package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes9.dex */
public abstract class a {
    public abstract void eK(boolean z);

    public void eL(boolean z) {
        com.baidu.swan.apps.storage.c.h.aPH().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean alD() {
        return com.baidu.swan.apps.storage.c.h.aPH().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ai.a aVar) {
    }

    public void O(Object obj) {
    }

    public Resources alE() {
        return null;
    }

    public void eM(boolean z) {
    }
}
