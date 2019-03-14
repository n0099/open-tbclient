package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aEC;
    public Bundle aEB = new Bundle();
    public String aED = "";
    public Bundle aEE = new Bundle();

    public abstract void t(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.fN(this.aED)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.aEC + " observer: " + this.aED);
            }
            b.a(this.aEC, this.aED, this.aEE);
        }
    }
}
