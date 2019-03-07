package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public final class b {
    private FrameLayout aRY = null;

    public void j(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.aRY == null) {
                this.aRY = new FrameLayout(viewGroup.getContext());
                this.aRY.setBackgroundResource(b.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aRY);
            viewGroup.addView(this.aRY, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aRY != null) {
            viewGroup.removeView(this.aRY);
            this.aRY = null;
        }
    }
}
