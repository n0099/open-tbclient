package com.baidu.tbadk.c;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View amG;
    private boolean amH;

    public a(View view) {
        this.amG = view;
    }

    public boolean Av() {
        return this.amH;
    }

    public void b(View view, boolean z) {
        if (view != null && this.amG != null && this.amG.getParent() == null) {
            this.amH = true;
            d.t(view).a(view, this.amG, z);
            Aw();
        }
    }

    public void s(View view) {
        if (view != null && this.amG != null && this.amG.getParent() != null && (view instanceof ViewGroup)) {
            Ax();
            ((ViewGroup) view).removeView(this.amG);
            this.amH = false;
        }
    }

    protected void Aw() {
    }

    protected void Ax() {
    }
}
