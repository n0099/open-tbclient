package com.baidu.swan.apps.adaptation;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes19.dex */
public class a {
    private i ctz;

    @NonNull
    public i afx() {
        if (this.ctz == null) {
            this.ctz = afy();
        }
        return this.ctz;
    }

    public i afy() {
        return new u();
    }
}
