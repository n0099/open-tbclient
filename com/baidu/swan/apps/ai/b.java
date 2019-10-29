package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout bpd = null;

    public void m(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bpd == null) {
                this.bpd = new FrameLayout(viewGroup.getContext());
                this.bpd.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bpd);
            viewGroup.addView(this.bpd, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.bpd != null) {
            viewGroup.removeView(this.bpd);
            this.bpd = null;
        }
    }
}
