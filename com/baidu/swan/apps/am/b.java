package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout bUA = null;

    public void q(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bUA == null) {
                this.bUA = new FrameLayout(viewGroup.getContext());
                this.bUA.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUA);
            viewGroup.addView(this.bUA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUA != null) {
            viewGroup.removeView(this.bUA);
            this.bUA = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bUA != null) {
            this.bUA.setVisibility(i);
        }
    }
}
