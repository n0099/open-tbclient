package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout boL = null;

    public void m(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.boL == null) {
                this.boL = new FrameLayout(viewGroup.getContext());
                this.boL.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.boL);
            viewGroup.addView(this.boL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.boL != null) {
            viewGroup.removeView(this.boL);
            this.boL = null;
        }
    }
}
