package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cti;
    public Bundle cth = new Bundle();
    public String ctj = "";
    public Bundle ctk = new Bundle();

    public abstract void A(@NonNull Bundle bundle);

    public void finish() {
        L(this.ctk);
    }

    public void L(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.mT(this.ctj)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cti + " observer: " + this.ctj);
            }
            b.a(this.cti, this.ctj, bundle);
        }
    }
}
