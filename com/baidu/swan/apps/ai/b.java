package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aVZ = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aVZ == null) {
                this.aVZ = new FrameLayout(viewGroup.getContext());
                this.aVZ.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aVZ);
            viewGroup.addView(this.aVZ, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aVZ != null) {
            viewGroup.removeView(this.aVZ);
            this.aVZ = null;
        }
    }
}
