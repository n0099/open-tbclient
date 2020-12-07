package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes25.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dqz;
    public Bundle dqy = new Bundle();
    public String dqA = "";
    public Bundle dqB = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.dqB);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rU(this.dqA)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dqz + " observer: " + this.dqA);
            }
            b.a(this.dqz, this.dqA, bundle);
        }
    }
}
