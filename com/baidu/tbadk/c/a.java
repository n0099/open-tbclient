package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View VD;
    private boolean VE;

    public a(View view) {
        this.VD = view;
    }

    public boolean sx() {
        return this.VE;
    }

    public void b(View view, boolean z) {
        if (view != null && this.VD != null && this.VD.getParent() == null) {
            this.VE = true;
            d.r(view).a(view, this.VD, z);
            sy();
        }
    }

    public void q(View view) {
        if (view != null && this.VD != null && this.VD.getParent() != null && (view instanceof ViewGroup)) {
            sz();
            ((ViewGroup) view).removeView(this.VD);
            this.VE = false;
        }
    }

    protected void sy() {
    }

    protected void sz() {
    }
}
