package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int baT;
    public Bundle baS = new Bundle();
    public String baU = "";
    public Bundle baV = new Bundle();

    public abstract void u(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.gS(this.baU)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.baT + " observer: " + this.baU);
            }
            b.a(this.baT, this.baU, this.baV);
        }
    }
}
