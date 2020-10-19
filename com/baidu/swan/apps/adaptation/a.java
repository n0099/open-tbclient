package com.baidu.swan.apps.adaptation;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.bdprivate.a.u;
/* loaded from: classes20.dex */
public class a {
    private i cgM;

    @NonNull
    public i abL() {
        if (this.cgM == null) {
            this.cgM = abM();
        }
        return this.cgM;
    }

    public i abM() {
        return new u();
    }
}
