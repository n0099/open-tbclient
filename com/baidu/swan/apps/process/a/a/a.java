package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes9.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bEa;
    public Bundle bDZ = new Bundle();
    public String bEb = "";
    public Bundle bEc = new Bundle();

    public abstract void y(@NonNull Bundle bundle);

    public void finish() {
        H(this.bEc);
    }

    public void H(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.jY(this.bEb)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.bEa + " observer: " + this.bEb);
            }
            b.a(this.bEa, this.bEb, bundle);
        }
    }
}
