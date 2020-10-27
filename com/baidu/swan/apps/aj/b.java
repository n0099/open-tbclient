package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public final class b {
    private FrameLayout dtt = null;

    public void E(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dtt == null) {
                this.dtt = new FrameLayout(viewGroup.getContext());
                this.dtt.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dtt);
            viewGroup.addView(this.dtt, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void F(ViewGroup viewGroup) {
        if (viewGroup != null && this.dtt != null) {
            viewGroup.removeView(this.dtt);
            this.dtt = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dtt != null) {
            this.dtt.setVisibility(i);
        }
    }
}
