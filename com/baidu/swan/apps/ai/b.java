package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aUR = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aUR == null) {
                this.aUR = new FrameLayout(viewGroup.getContext());
                this.aUR.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aUR);
            viewGroup.addView(this.aUR, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aUR != null) {
            viewGroup.removeView(this.aUR);
            this.aUR = null;
        }
    }
}
