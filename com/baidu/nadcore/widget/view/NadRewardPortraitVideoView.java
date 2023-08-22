package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.tieba.R;
import com.baidu.tieba.f31;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wr0;
/* loaded from: classes3.dex */
public class NadRewardPortraitVideoView extends NadRewardVideoView {
    public PortraitVideoTailView u;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdBaseModel adBaseModel;
            if (NadRewardPortraitVideoView.this.getTag() instanceof AdBaseModel) {
                adBaseModel = (AdBaseModel) NadRewardPortraitVideoView.this.getTag();
            } else {
                adBaseModel = null;
            }
            if (NadRewardPortraitVideoView.this.a != null) {
                NadRewardPortraitVideoView.this.a.b(adBaseModel);
            }
        }
    }

    public NadRewardPortraitVideoView(Context context) {
        super(context);
    }

    public final void M(AdBaseModel adBaseModel) {
        PortraitVideoTailView portraitVideoTailView = this.u;
        if (portraitVideoTailView != null && adBaseModel != null) {
            wr0 wr0Var = adBaseModel.i;
            if (wr0Var != null && wr0Var.l) {
                portraitVideoTailView.setAdInfo(wr0Var);
            }
            this.u.setOnAdClickListener(new a());
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        super.r(adBaseModel);
        M(adBaseModel);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, vr0 vr0Var) {
        int i;
        Integer num;
        if (vr0Var != null && (num = (Integer) f31.b(vr0Var.a, AdBaseModel.STYLE.VIDEO)) != null) {
            i = num.intValue();
        } else {
            i = R.layout.nad_reward_video_view;
        }
        layoutInflater.inflate(i, this);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i, vr0 vr0Var) {
        super(context, attributeSet, i, vr0Var);
        this.u = (PortraitVideoTailView) findViewById(R.id.nad_portrait_video_tail_frame_view);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void I() {
        if (this.u == null || !N()) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.m;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(0);
        }
        this.u.e();
    }

    public boolean N() {
        PortraitVideoTailView portraitVideoTailView = this.u;
        if (portraitVideoTailView != null && portraitVideoTailView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void J() {
        if (this.u == null || N() || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.m;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(8);
        }
        this.u.j((AdBaseModel) getTag());
        this.u.d();
        this.u.bringToFront();
    }
}
