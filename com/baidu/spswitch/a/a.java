package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes12.dex */
public class a {
    private final View aVI;
    private boolean aVJ;

    public a(View view) {
        this.aVI = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.aVJ = z;
        if (!z && this.aVI.getVisibility() == 4) {
            this.aVI.setVisibility(8);
        }
    }
}
