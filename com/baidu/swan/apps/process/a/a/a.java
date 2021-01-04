package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dvy;
    public Bundle dvx = new Bundle();
    public String dvz = "";
    public Bundle dvA = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.dvA);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rN(this.dvz)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dvy + " observer: " + this.dvz);
            }
            b.a(this.dvy, this.dvz, bundle);
        }
    }
}
