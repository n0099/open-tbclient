package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aHF;
    public Bundle aHE = new Bundle();
    public String aHG = "";
    public Bundle aHH = new Bundle();

    public abstract void u(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.gn(this.aHG)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.aHF + " observer: " + this.aHG);
            }
            b.a(this.aHF, this.aHG, this.aHH);
        }
    }
}
