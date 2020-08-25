package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public final class b {
    private FrameLayout cWD = null;

    public void z(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cWD == null) {
                this.cWD = new FrameLayout(viewGroup.getContext());
                this.cWD.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cWD);
            viewGroup.addView(this.cWD, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void A(ViewGroup viewGroup) {
        if (viewGroup != null && this.cWD != null) {
            viewGroup.removeView(this.cWD);
            this.cWD = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cWD != null) {
            this.cWD.setVisibility(i);
        }
    }
}
