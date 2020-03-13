package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout bUB = null;

    public void q(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bUB == null) {
                this.bUB = new FrameLayout(viewGroup.getContext());
                this.bUB.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUB);
            viewGroup.addView(this.bUB, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUB != null) {
            viewGroup.removeView(this.bUB);
            this.bUB = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bUB != null) {
            this.bUB.setVisibility(i);
        }
    }
}
