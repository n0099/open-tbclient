package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes8.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cIE;
    public Bundle cID = new Bundle();
    public String cIF = "";
    public Bundle cIG = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.cIG);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.pG(this.cIF)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cIE + " observer: " + this.cIF);
            }
            b.a(this.cIE, this.cIF, bundle);
        }
    }
}
