package com.baidu.swan.apps.ak;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public final class b {
    private FrameLayout cFD = null;

    public void v(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.cFD == null) {
                this.cFD = new FrameLayout(viewGroup.getContext());
                this.cFD.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cFD);
            viewGroup.addView(this.cFD, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void w(ViewGroup viewGroup) {
        if (viewGroup != null && this.cFD != null) {
            viewGroup.removeView(this.cFD);
            this.cFD = null;
        }
    }

    public void setVisibility(int i) {
        if (this.cFD != null) {
            this.cFD.setVisibility(i);
        }
    }
}
