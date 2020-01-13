package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public final class b {
    private FrameLayout bQu = null;

    public void p(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bQu == null) {
                this.bQu = new FrameLayout(viewGroup.getContext());
                this.bQu.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bQu);
            viewGroup.addView(this.bQu, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void q(ViewGroup viewGroup) {
        if (viewGroup != null && this.bQu != null) {
            viewGroup.removeView(this.bQu);
            this.bQu = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bQu != null) {
            this.bQu.setVisibility(i);
        }
    }
}
