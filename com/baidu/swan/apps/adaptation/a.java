package com.baidu.swan.apps.adaptation;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes7.dex */
public class a {
    private i cCT;

    @NonNull
    public i ags() {
        if (this.cCT == null) {
            this.cCT = agt();
        }
        return this.cCT;
    }

    public i agt() {
        return new u();
    }
}
