package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout ctI = null;

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.ctI == null) {
                this.ctI = new FrameLayout(viewGroup.getContext());
                this.ctI.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.ctI);
            viewGroup.addView(this.ctI, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void s(ViewGroup viewGroup) {
        if (viewGroup != null && this.ctI != null) {
            viewGroup.removeView(this.ctI);
            this.ctI = null;
        }
    }

    public void setVisibility(int i) {
        if (this.ctI != null) {
            this.ctI.setVisibility(i);
        }
    }
}
