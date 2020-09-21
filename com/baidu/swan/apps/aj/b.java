package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes3.dex */
public final class b {
    private FrameLayout cYH = null;

    public void B(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cYH == null) {
                this.cYH = new FrameLayout(viewGroup.getContext());
                this.cYH.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cYH);
            viewGroup.addView(this.cYH, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void C(ViewGroup viewGroup) {
        if (viewGroup != null && this.cYH != null) {
            viewGroup.removeView(this.cYH);
            this.cYH = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cYH != null) {
            this.cYH.setVisibility(i);
        }
    }
}
