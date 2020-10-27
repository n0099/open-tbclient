package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes10.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dfm;
    public Bundle dfl = new Bundle();
    public String dfn = "";
    public Bundle dfo = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.dfo);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rf(this.dfn)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dfm + " observer: " + this.dfn);
            }
            b.a(this.dfm, this.dfn, bundle);
        }
    }
}
