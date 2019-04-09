package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aSd = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aSd == null) {
                this.aSd = new FrameLayout(viewGroup.getContext());
                this.aSd.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aSd);
            viewGroup.addView(this.aSd, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aSd != null) {
            viewGroup.removeView(this.aSd);
            this.aSd = null;
        }
    }
}
