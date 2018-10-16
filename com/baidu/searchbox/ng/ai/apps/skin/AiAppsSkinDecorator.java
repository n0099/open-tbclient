package com.baidu.searchbox.ng.ai.apps.skin;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public final class AiAppsSkinDecorator {
    private FrameLayout mCoverLayer = null;

    public void decorateNightModeCover(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.mCoverLayer == null) {
                this.mCoverLayer = new FrameLayout(viewGroup.getContext());
                this.mCoverLayer.setBackgroundResource(R.color.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.mCoverLayer);
            viewGroup.addView(this.mCoverLayer, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void removeNightModeCover(ViewGroup viewGroup) {
        if (viewGroup != null && this.mCoverLayer != null) {
            viewGroup.removeView(this.mCoverLayer);
            this.mCoverLayer = null;
        }
    }
}
