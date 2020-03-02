package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bIR;
    public Bundle bIQ = new Bundle();
    public String bIS = "";
    public Bundle bIT = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bIT);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.kq(this.bIS)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bIR + " observer: " + this.bIS);
            }
            b.a(this.bIR, this.bIS, bundle);
        }
    }
}
