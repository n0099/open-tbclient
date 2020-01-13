package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes10.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bEL;
    public Bundle bEK = new Bundle();
    public String bEM = "";
    public Bundle bEN = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bEN);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.kb(this.bEM)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bEL + " observer: " + this.bEM);
            }
            b.a(this.bEL, this.bEM, bundle);
        }
    }
}
