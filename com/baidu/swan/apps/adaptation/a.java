package com.baidu.swan.apps.adaptation;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes20.dex */
public class a {
    private i cAt;

    @NonNull
    public i aiF() {
        if (this.cAt == null) {
            this.cAt = aiG();
        }
        return this.cAt;
    }

    public i aiG() {
        return new u();
    }
}
