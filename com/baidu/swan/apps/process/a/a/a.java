package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int chS;
    public Bundle chR = new Bundle();
    public String chT = "";
    public Bundle chU = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.chU);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.lC(this.chT)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.chS + " observer: " + this.chT);
            }
            b.a(this.chS, this.chT, bundle);
        }
    }
}
