package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aHh;
    public Bundle aHg = new Bundle();
    public String aHi = "";
    public Bundle aHj = new Bundle();

    public abstract void u(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.gl(this.aHi)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.aHh + " observer: " + this.aHi);
            }
            b.a(this.aHh, this.aHi, this.aHj);
        }
    }
}
