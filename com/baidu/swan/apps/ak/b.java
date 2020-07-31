package com.baidu.swan.apps.ak;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public final class b {
    private FrameLayout cNE = null;

    public void y(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cNE == null) {
                this.cNE = new FrameLayout(viewGroup.getContext());
                this.cNE.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cNE);
            viewGroup.addView(this.cNE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void z(ViewGroup viewGroup) {
        if (viewGroup != null && this.cNE != null) {
            viewGroup.removeView(this.cNE);
            this.cNE = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cNE != null) {
            this.cNE.setVisibility(i);
        }
    }
}
