package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aRZ = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aRZ == null) {
                this.aRZ = new FrameLayout(viewGroup.getContext());
                this.aRZ.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aRZ);
            viewGroup.addView(this.aRZ, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aRZ != null) {
            viewGroup.removeView(this.aRZ);
            this.aRZ = null;
        }
    }
}
