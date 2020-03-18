package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bJd;
    public Bundle bJc = new Bundle();
    public String bJe = "";
    public Bundle bJf = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bJf);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.kp(this.bJe)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bJd + " observer: " + this.bJe);
            }
            b.a(this.bJd, this.bJe, bundle);
        }
    }
}
