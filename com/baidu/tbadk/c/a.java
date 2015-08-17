package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View aus;
    private boolean aut;

    public a(View view) {
        this.aus = view;
    }

    public boolean Cq() {
        return this.aut;
    }

    public void b(View view, boolean z) {
        if (view != null && this.aus != null && this.aus.getParent() == null) {
            this.aut = true;
            d.w(view).a(view, this.aus, z);
            Cr();
        }
    }

    public void u(View view) {
        if (view != null && this.aus != null && this.aus.getParent() != null && (view instanceof ViewGroup)) {
            Cs();
            ((ViewGroup) view).removeView(this.aus);
            this.aut = false;
        }
    }

    public void v(View view) {
        b(view, false);
    }

    protected void Cr() {
    }

    protected void Cs() {
    }
}
