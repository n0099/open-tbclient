package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int chM;
    public Bundle chL = new Bundle();
    public String chN = "";
    public Bundle chO = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.chO);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.lC(this.chN)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.chM + " observer: " + this.chN);
            }
            b.a(this.chM, this.chN, bundle);
        }
    }
}
