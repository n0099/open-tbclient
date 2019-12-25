package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes11.dex */
public class a {
    private final View aUQ;
    private boolean aUR;

    public a(View view) {
        this.aUQ = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.aUR = z;
        if (!z && this.aUQ.getVisibility() == 4) {
            this.aUQ.setVisibility(8);
        }
    }
}
