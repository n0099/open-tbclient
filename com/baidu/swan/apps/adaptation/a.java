package com.baidu.swan.apps.adaptation;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes20.dex */
public class a {
    private i cvl;

    @NonNull
    public i agf() {
        if (this.cvl == null) {
            this.cvl = agg();
        }
        return this.cvl;
    }

    public i agg() {
        return new u();
    }
}
