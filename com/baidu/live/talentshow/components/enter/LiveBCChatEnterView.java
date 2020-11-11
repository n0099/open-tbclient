package com.baidu.live.talentshow.components.enter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class LiveBCChatEnterView extends FrameLayout {
    private ImageView bvJ;
    private FrameLayout bvK;
    private ImageView bvL;

    public LiveBCChatEnterView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LiveBCChatEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LiveBCChatEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, a.g.talent_live_bc_audience_enter_view, this);
        this.bvK = (FrameLayout) inflate.findViewById(a.f.ala_video_bb_layout);
        this.bvJ = (ImageView) inflate.findViewById(a.f.ala_video_bb_connect);
        this.bvL = (ImageView) inflate.findViewById(a.f.video_bc_red_dot);
    }

    public void setEnterVisible(boolean z) {
        if (this.bvK != null) {
            this.bvK.setVisibility(z ? 0 : 8);
        }
    }

    public void setRedDotVisible(boolean z) {
        this.bvL.setVisibility(z ? 0 : 8);
    }

    public ImageView getEnterImage() {
        return this.bvJ;
    }

    public void setEnterImageDrawable(int i) {
        if (this.bvJ != null) {
            this.bvJ.setImageResource(i);
        }
    }
}
