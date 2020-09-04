package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes8.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cII;
    public Bundle cIH = new Bundle();
    public String cIJ = "";
    public Bundle cIK = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.cIK);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.pH(this.cIJ)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cII + " observer: " + this.cIJ);
            }
            b.a(this.cII, this.cIJ, bundle);
        }
    }
}
