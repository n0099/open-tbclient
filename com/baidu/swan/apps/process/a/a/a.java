package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dqJ;
    public Bundle dqI = new Bundle();
    public String dqK = "";
    public Bundle dqL = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.dqL);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.qC(this.dqK)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dqJ + " observer: " + this.dqK);
            }
            b.a(this.dqJ, this.dqK, bundle);
        }
    }
}
