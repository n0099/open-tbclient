package com.baidu.swan.apps.ak;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout cKn = null;

    public void x(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cKn == null) {
                this.cKn = new FrameLayout(viewGroup.getContext());
                this.cKn.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cKn);
            viewGroup.addView(this.cKn, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void y(ViewGroup viewGroup) {
        if (viewGroup != null && this.cKn != null) {
            viewGroup.removeView(this.cKn);
            this.cKn = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cKn != null) {
            this.cKn.setVisibility(i);
        }
    }
}
