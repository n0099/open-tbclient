package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.HorizontalVideoTailView;
import com.baidu.tieba.R;
import com.baidu.tieba.on0;
import com.baidu.tieba.py0;
/* loaded from: classes3.dex */
public class NadRewardHorizontalVideoView extends NadRewardVideoView {
    public HorizontalVideoTailView o;

    public NadRewardHorizontalVideoView(Context context) {
        super(context);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void h(LayoutInflater layoutInflater, on0 on0Var) {
        int i;
        Integer num;
        if (on0Var != null && (num = (Integer) py0.b(on0Var.a, AdBaseModel.STYLE.VIDEO)) != null) {
            i = num.intValue();
        } else {
            i = R.layout.nad_reward_horizontal_video_view;
        }
        layoutInflater.inflate(i, this);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
        this.o = (HorizontalVideoTailView) findViewById(R.id.nad_horizontal_video_tail_frame_view);
    }
}
