package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class a {
    private final View baj;
    private boolean bak;

    public a(View view) {
        this.baj = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.bak = z;
        if (!z && this.baj.getVisibility() == 4) {
            this.baj.setVisibility(8);
        }
    }
}
