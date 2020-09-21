package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes3.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cKI;
    public Bundle cKH = new Bundle();
    public String cKJ = "";
    public Bundle cKK = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.cKK);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.qa(this.cKJ)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cKI + " observer: " + this.cKJ);
            }
            b.a(this.cKI, this.cKJ, bundle);
        }
    }
}
