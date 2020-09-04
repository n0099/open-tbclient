package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public final class b {
    private FrameLayout cWH = null;

    public void z(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cWH == null) {
                this.cWH = new FrameLayout(viewGroup.getContext());
                this.cWH.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cWH);
            viewGroup.addView(this.cWH, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void A(ViewGroup viewGroup) {
        if (viewGroup != null && this.cWH != null) {
            viewGroup.removeView(this.cWH);
            this.cWH = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cWH != null) {
            this.cWH.setVisibility(i);
        }
    }
}
