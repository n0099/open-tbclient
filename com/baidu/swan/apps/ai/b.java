package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public final class b {
    private FrameLayout dIv = null;

    public void J(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dIv == null) {
                this.dIv = new FrameLayout(viewGroup.getContext());
                this.dIv.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dIv);
            viewGroup.addView(this.dIv, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void K(ViewGroup viewGroup) {
        if (viewGroup != null && this.dIv != null) {
            viewGroup.removeView(this.dIv);
            this.dIv = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dIv != null) {
            this.dIv.setVisibility(i);
        }
    }
}
