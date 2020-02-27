package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout bUz = null;

    public void q(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bUz == null) {
                this.bUz = new FrameLayout(viewGroup.getContext());
                this.bUz.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUz);
            viewGroup.addView(this.bUz, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUz != null) {
            viewGroup.removeView(this.bUz);
            this.bUz = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bUz != null) {
            this.bUz.setVisibility(i);
        }
    }
}
