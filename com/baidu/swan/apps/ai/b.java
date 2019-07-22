package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aVB = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aVB == null) {
                this.aVB = new FrameLayout(viewGroup.getContext());
                this.aVB.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aVB);
            viewGroup.addView(this.aVB, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aVB != null) {
            viewGroup.removeView(this.aVB);
            this.aVB = null;
        }
    }
}
