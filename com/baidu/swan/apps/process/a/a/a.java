package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int djA;
    public Bundle djz = new Bundle();
    public String djB = "";
    public Bundle djC = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.djC);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rn(this.djB)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.djA + " observer: " + this.djB);
            }
            b.a(this.djA, this.djB, bundle);
        }
    }
}
