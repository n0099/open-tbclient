package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View alF;
    private boolean alG;

    public a(View view) {
        this.alF = view;
    }

    public boolean zI() {
        return this.alG;
    }

    public void b(View view, boolean z) {
        if (view != null && this.alF != null && this.alF.getParent() == null) {
            this.alG = true;
            d.q(view).a(view, this.alF, z);
            zJ();
        }
    }

    public void p(View view) {
        if (view != null && this.alF != null && this.alF.getParent() != null && (view instanceof ViewGroup)) {
            zK();
            ((ViewGroup) view).removeView(this.alF);
            this.alG = false;
        }
    }

    protected void zJ() {
    }

    protected void zK() {
    }
}
