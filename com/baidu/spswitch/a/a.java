package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class a {
    private final View aZV;
    private boolean aZW;

    public a(View view) {
        this.aZV = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.aZW = z;
        if (!z && this.aZV.getVisibility() == 4) {
            this.aZV.setVisibility(8);
        }
    }
}
