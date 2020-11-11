package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes10.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dlh;
    public Bundle dlg = new Bundle();
    public String dli = "";
    public Bundle dlj = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.dlj);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rt(this.dli)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dlh + " observer: " + this.dli);
            }
            b.a(this.dlh, this.dli, bundle);
        }
    }
}
