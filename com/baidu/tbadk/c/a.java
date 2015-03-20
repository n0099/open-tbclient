package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View alx;
    private boolean aly;

    public a(View view) {
        this.alx = view;
    }

    public boolean zC() {
        return this.aly;
    }

    public void b(View view, boolean z) {
        if (view != null && this.alx != null && this.alx.getParent() == null) {
            this.aly = true;
            d.q(view).a(view, this.alx, z);
            zD();
        }
    }

    public void p(View view) {
        if (view != null && this.alx != null && this.alx.getParent() != null && (view instanceof ViewGroup)) {
            zE();
            ((ViewGroup) view).removeView(this.alx);
            this.aly = false;
        }
    }

    protected void zD() {
    }

    protected void zE() {
    }
}
