package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public final class b {
    private FrameLayout bPK = null;

    public void m(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bPK == null) {
                this.bPK = new FrameLayout(viewGroup.getContext());
                this.bPK.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bPK);
            viewGroup.addView(this.bPK, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.bPK != null) {
            viewGroup.removeView(this.bPK);
            this.bPK = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bPK != null) {
            this.bPK.setVisibility(i);
        }
    }
}
