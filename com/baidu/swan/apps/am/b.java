package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout ctC = null;

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.ctC == null) {
                this.ctC = new FrameLayout(viewGroup.getContext());
                this.ctC.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.ctC);
            viewGroup.addView(this.ctC, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void s(ViewGroup viewGroup) {
        if (viewGroup != null && this.ctC != null) {
            viewGroup.removeView(this.ctC);
            this.ctC = null;
        }
    }

    public void setVisibility(int i) {
        if (this.ctC != null) {
            this.ctC.setVisibility(i);
        }
    }
}
