package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aSc = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aSc == null) {
                this.aSc = new FrameLayout(viewGroup.getContext());
                this.aSc.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aSc);
            viewGroup.addView(this.aSc, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aSc != null) {
            viewGroup.removeView(this.aSc);
            this.aSc = null;
        }
    }
}
