package com.baidu.swan.apps.adaptation;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes20.dex */
public class a {
    private i cpm;

    @NonNull
    public i adF() {
        if (this.cpm == null) {
            this.cpm = adG();
        }
        return this.cpm;
    }

    public i adG() {
        return new u();
    }
}
