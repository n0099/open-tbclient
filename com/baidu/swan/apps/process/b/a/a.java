package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public abstract class a {
    private static final boolean DEBUG = c.DEBUG;
    public int aEB;
    public Bundle aEA = new Bundle();
    public String aEC = "";
    public Bundle aED = new Bundle();

    public abstract void t(@NonNull Bundle bundle);

    public void finish() {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.b.b.d.a.fN(this.aEC)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.aEB + " observer: " + this.aEC);
            }
            b.a(this.aEB, this.aEC, this.aED);
        }
    }
}
