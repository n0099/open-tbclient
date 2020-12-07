package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes25.dex */
public final class b {
    private FrameLayout dED = null;

    public void C(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dED == null) {
                this.dED = new FrameLayout(viewGroup.getContext());
                this.dED.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dED);
            viewGroup.addView(this.dED, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void D(ViewGroup viewGroup) {
        if (viewGroup != null && this.dED != null) {
            viewGroup.removeView(this.dED);
            this.dED = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dED != null) {
            this.dED.setVisibility(i);
        }
    }
}
