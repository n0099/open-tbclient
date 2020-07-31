package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes7.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cAv;
    public Bundle cAu = new Bundle();
    public String cAw = "";
    public Bundle cAx = new Bundle();

    public abstract void A(@NonNull Bundle bundle);

    public void finish() {
        M(this.cAx);
    }

    public void M(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.nI(this.cAw)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cAv + " observer: " + this.cAw);
            }
            b.a(this.cAv, this.cAw, bundle);
        }
    }
}
