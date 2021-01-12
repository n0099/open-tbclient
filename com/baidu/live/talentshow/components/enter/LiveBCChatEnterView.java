package com.baidu.live.talentshow.components.enter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class LiveBCChatEnterView extends FrameLayout {
    private ImageView bzj;
    private FrameLayout bzk;
    private ImageView bzl;

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
        this.bzk = (FrameLayout) inflate.findViewById(a.f.ala_video_bb_layout);
        this.bzj = (ImageView) inflate.findViewById(a.f.ala_video_bb_connect);
        this.bzl = (ImageView) inflate.findViewById(a.f.video_bc_red_dot);
    }

    public void setEnterVisible(boolean z) {
        if (this.bzk != null) {
            this.bzk.setVisibility(z ? 0 : 8);
        }
    }

    public void setRedDotVisible(boolean z) {
        this.bzl.setVisibility(z ? 0 : 8);
    }

    public ImageView getEnterImage() {
        return this.bzj;
    }

    public void setEnterImageDrawable(int i) {
        if (this.bzj != null) {
            this.bzj.setImageResource(i);
        }
    }
}
