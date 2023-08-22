package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.HorizontalVideoTailView;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.tieba.R;
import com.baidu.tieba.f31;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wr0;
/* loaded from: classes3.dex */
public class NadRewardHorizontalVideoView extends NadRewardVideoView {
    public HorizontalVideoTailView u;

    public NadRewardHorizontalVideoView(Context context) {
        super(context);
    }

    public final void K(AdBaseModel adBaseModel) {
        wr0 wr0Var;
        HorizontalVideoTailView horizontalVideoTailView = this.u;
        if (horizontalVideoTailView != null && adBaseModel != null && (wr0Var = adBaseModel.i) != null && wr0Var.l) {
            horizontalVideoTailView.setAdInfo(wr0Var);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        super.r(adBaseModel);
        K(adBaseModel);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, vr0 vr0Var) {
        int i;
        Integer num;
        if (vr0Var != null && (num = (Integer) f31.b(vr0Var.a, AdBaseModel.STYLE.VIDEO)) != null) {
            i = num.intValue();
        } else {
            i = R.layout.nad_reward_horizontal_video_view;
        }
        layoutInflater.inflate(i, this);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardHorizontalVideoView(Context context, AttributeSet attributeSet, int i, vr0 vr0Var) {
        super(context, attributeSet, i, vr0Var);
        this.u = (HorizontalVideoTailView) findViewById(R.id.nad_horizontal_video_tail_frame_view);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void I() {
        if (this.u == null || !L()) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.m;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(0);
        }
        this.u.d();
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void J() {
        if (this.u == null || L() || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.m;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(8);
        }
        this.u.n((AdBaseModel) getTag());
        this.u.bringToFront();
    }

    public boolean L() {
        HorizontalVideoTailView horizontalVideoTailView = this.u;
        if (horizontalVideoTailView != null && horizontalVideoTailView.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
