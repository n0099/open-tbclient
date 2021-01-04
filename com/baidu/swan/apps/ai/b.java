package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public final class b {
    private FrameLayout dNh = null;

    public void J(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dNh == null) {
                this.dNh = new FrameLayout(viewGroup.getContext());
                this.dNh.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dNh);
            viewGroup.addView(this.dNh, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void K(ViewGroup viewGroup) {
        if (viewGroup != null && this.dNh != null) {
            viewGroup.removeView(this.dNh);
            this.dNh = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dNh != null) {
            this.dNh.setVisibility(i);
        }
    }
}
