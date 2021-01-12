package com.baidu.swan.apps.adaptation;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes6.dex */
public class a {
    private i cAx;

    @NonNull
    public i afU() {
        if (this.cAx == null) {
            this.cAx = afV();
        }
        return this.cAx;
    }

    public i afV() {
        return new u();
    }
}
