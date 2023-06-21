package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.tieba.R;
import com.baidu.tieba.a31;
import com.baidu.tieba.bs0;
import com.baidu.tieba.cs0;
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

    public final void N(AdBaseModel adBaseModel) {
        PortraitVideoTailView portraitVideoTailView = this.u;
        if (portraitVideoTailView != null && adBaseModel != null) {
            cs0 cs0Var = adBaseModel.i;
            if (cs0Var != null && cs0Var.k) {
                portraitVideoTailView.setAdInfo(cs0Var);
            }
            this.u.setOnAdClickListener(new a());
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        super.r(adBaseModel);
        N(adBaseModel);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView, com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, bs0 bs0Var) {
        int i;
        Integer num;
        if (bs0Var != null && (num = (Integer) a31.b(bs0Var.a, AdBaseModel.STYLE.VIDEO)) != null) {
            i = num.intValue();
        } else {
            i = R.layout.nad_reward_video_view;
        }
        layoutInflater.inflate(i, this);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardPortraitVideoView(Context context, AttributeSet attributeSet, int i, bs0 bs0Var) {
        super(context, attributeSet, i, bs0Var);
        this.u = (PortraitVideoTailView) findViewById(R.id.nad_portrait_video_tail_frame_view);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void I() {
        if (this.u == null || !O()) {
            return;
        }
        NadRewardOperateView nadRewardOperateView = this.m;
        if (nadRewardOperateView != null) {
            nadRewardOperateView.setVisibility(0);
        }
        this.u.e();
    }

    public boolean O() {
        PortraitVideoTailView portraitVideoTailView = this.u;
        if (portraitVideoTailView != null && portraitVideoTailView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardVideoView
    public void J() {
        if (this.u == null || O() || !(getTag() instanceof AdBaseModel)) {
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
