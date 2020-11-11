package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public final class b {
    private FrameLayout dzl = null;

    public void G(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dzl == null) {
                this.dzl = new FrameLayout(viewGroup.getContext());
                this.dzl.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dzl);
            viewGroup.addView(this.dzl, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void H(ViewGroup viewGroup) {
        if (viewGroup != null && this.dzl != null) {
            viewGroup.removeView(this.dzl);
            this.dzl = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dzl != null) {
            this.dzl.setVisibility(i);
        }
    }
}
