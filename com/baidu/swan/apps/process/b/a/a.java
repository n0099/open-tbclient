package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aEF;
    public Bundle aEE = new Bundle();
    public String aEG = "";
    public Bundle aEH = new Bundle();

    public abstract void t(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.fO(this.aEG)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.aEF + " observer: " + this.aEG);
            }
            b.a(this.aEF, this.aEG, this.aEH);
        }
    }
}
