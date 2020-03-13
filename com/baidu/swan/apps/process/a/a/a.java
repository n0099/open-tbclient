package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bIS;
    public Bundle bIR = new Bundle();
    public String bIT = "";
    public Bundle bIU = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bIU);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.kq(this.bIT)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bIS + " observer: " + this.bIT);
            }
            b.a(this.bIS, this.bIT, bundle);
        }
    }
}
