package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class a {
    private final View aZW;
    private boolean aZX;

    public a(View view) {
        this.aZW = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.aZX = z;
        if (!z && this.aZW.getVisibility() == 4) {
            this.aZW.setVisibility(8);
        }
    }
}
