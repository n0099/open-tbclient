package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.tieba.on0;
import com.baidu.tieba.py0;
/* loaded from: classes3.dex */
public class NadRewardPortraitVideoView extends NadRewardVideoView {
    public PortraitVideoTailView o;

    public NadRewardPortraitVideoView(Context context) {
        super(context);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void h(LayoutInflater layoutInflater, on0 on0Var) {
        int i;
        Integer num;
        if (on0Var != null && (num = (Integer) py0.b(on0Var.a, AdBaseModel.STYLE.VIDEO)) != null) {
            i = num.intValue();
        } else {
            i = R.layout.nad_reward_video_view;
        }
        layoutInflater.inflate(i, this);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
        this.o = (PortraitVideoTailView) findViewById(R.id.nad_portrait_video_tail_frame_view);
    }
}
