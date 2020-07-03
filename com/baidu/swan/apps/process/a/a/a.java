package com.baidu.swan.apps.process.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
/* loaded from: classes11.dex */
public abstract class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cxW;
    public Bundle cxV = new Bundle();
    public String cxX = "";
    public Bundle cxY = new Bundle();

    public abstract void A(@NonNull Bundle bundle);

    public void finish() {
        L(this.cxY);
    }

    public void L(@Nullable Bundle bundle) {
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "messenger delegation finish");
        }
        if (!com.baidu.swan.apps.process.a.b.d.a.nb(this.cxX)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.cxW + " observer: " + this.cxX);
            }
            b.a(this.cxW, this.cxX, bundle);
        }
    }
}
