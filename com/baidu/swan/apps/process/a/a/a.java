package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dux;
    public Bundle duw = new Bundle();
    public String duy = "";
    public Bundle duz = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        K(this.duz);
    }

    public void K(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.rb(this.duy)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.dux + " observer: " + this.duy);
            }
            b.a(this.dux, this.duy, bundle);
        }
    }
}
