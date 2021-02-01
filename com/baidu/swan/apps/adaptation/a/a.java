package com.baidu.swan.apps.adaptation.a;

import android.content.res.Resources;
/* loaded from: classes9.dex */
public abstract class a {
    public abstract void eI(boolean z);

    public void eJ(boolean z) {
        com.baidu.swan.apps.storage.c.h.aMh().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public boolean aii() {
        return com.baidu.swan.apps.storage.c.h.aMh().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public void a(Object obj, com.baidu.swan.apps.ai.a aVar) {
    }

    public void O(Object obj) {
    }

    public Resources aij() {
        return null;
    }

    public void eK(boolean z) {
    }
}
