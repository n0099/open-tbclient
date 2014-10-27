package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    private boolean VA;
    protected View Vz;

    public a(View view) {
        this.Vz = view;
    }

    public boolean sv() {
        return this.VA;
    }

    public void b(View view, boolean z) {
        if (view != null && this.Vz != null && this.Vz.getParent() == null) {
            this.VA = true;
            d.r(view).a(view, this.Vz, z);
            sw();
        }
    }

    public void q(View view) {
        if (view != null && this.Vz != null && this.Vz.getParent() != null && (view instanceof ViewGroup)) {
            ((ViewGroup) view).removeView(this.Vz);
            this.VA = false;
            sx();
        }
    }

    protected void sw() {
    }

    protected void sx() {
    }
}
