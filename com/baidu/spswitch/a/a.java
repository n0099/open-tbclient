package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class a {
    private final View aZU;
    private boolean aZV;

    public a(View view) {
        this.aZU = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.aZV = z;
        if (!z && this.aZU.getVisibility() == 4) {
            this.aZU.setVisibility(8);
        }
    }
}
