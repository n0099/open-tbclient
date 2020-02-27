package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bIQ;
    public Bundle bIP = new Bundle();
    public String bIR = "";
    public Bundle bIS = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bIS);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.kq(this.bIR)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bIQ + " observer: " + this.bIR);
            }
            b.a(this.bIQ, this.bIR, bundle);
        }
    }
}
