package com.baidu.live.talentshow.components.enter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class LiveBCChatEnterView extends FrameLayout {
    private ImageView bCP;
    private FrameLayout bCQ;
    private ImageView bCR;

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
        this.bCQ = (FrameLayout) inflate.findViewById(a.f.ala_video_bb_layout);
        this.bCP = (ImageView) inflate.findViewById(a.f.ala_video_bb_connect);
        this.bCR = (ImageView) inflate.findViewById(a.f.video_bc_red_dot);
    }

    public void setEnterVisible(boolean z) {
        if (this.bCQ != null) {
            this.bCQ.setVisibility(z ? 0 : 8);
        }
    }

    public void setRedDotVisible(boolean z) {
        this.bCR.setVisibility(z ? 0 : 8);
    }

    public ImageView getEnterImage() {
        return this.bCP;
    }

    public void setEnterImageDrawable(int i) {
        if (this.bCP != null) {
            this.bCP.setImageResource(i);
        }
    }
}
