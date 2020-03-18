package com.baidu.swan.apps.am;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout bUM = null;

    public void q(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.bUM == null) {
                this.bUM = new FrameLayout(viewGroup.getContext());
                this.bUM.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUM);
            viewGroup.addView(this.bUM, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUM != null) {
            viewGroup.removeView(this.bUM);
            this.bUM = null;
        }
    }

    public void setVisibility(int i) {
        if (this.bUM != null) {
            this.bUM.setVisibility(i);
        }
    }
}
