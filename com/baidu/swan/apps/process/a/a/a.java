package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes10.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cWL;
    public Bundle cWK = new Bundle();
    public String cWM = "";
    public Bundle cWN = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.cWN);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.qM(this.cWM)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cWL + " observer: " + this.cWM);
            }
            b.a(this.cWL, this.cWM, bundle);
        }
    }
}
