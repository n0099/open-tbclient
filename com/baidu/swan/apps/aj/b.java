package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public final class b {
    private FrameLayout dxE = null;

    public void C(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dxE == null) {
                this.dxE = new FrameLayout(viewGroup.getContext());
                this.dxE.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dxE);
            viewGroup.addView(this.dxE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void D(ViewGroup viewGroup) {
        if (viewGroup != null && this.dxE != null) {
            viewGroup.removeView(this.dxE);
            this.dxE = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dxE != null) {
            this.dxE.setVisibility(i);
        }
    }
}
