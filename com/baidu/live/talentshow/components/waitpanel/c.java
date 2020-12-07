package com.baidu.live.talentshow.components.waitpanel;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<LiveVideoBCPanelData> implements View.OnClickListener {
    private HeadImageView bAA;
    private HeadImageView bAB;
    private TBLottieAnimationView bAC;
    private Button bAD;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAE;
    private a bAF;
    private TextView bAG;
    private TextView bAH;
    private LiveVideoBCPanelData bAz;
    private TextView byY;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(LiveVideoBCPanelData liveVideoBCPanelData);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mContext = tbPageContext.getPageActivity();
        registerListener();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.talent_dialog_audience_chat;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    /* renamed from: d */
    public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
        if (liveVideoBCPanelData != null) {
            this.bAz = liveVideoBCPanelData;
            this.byY.setText(this.mContext.getString(a.h.talent_count_down) + liveVideoBCPanelData.getDownTime() + "s");
            this.bAB.startLoad(liveVideoBCPanelData.getAnchorPortrait(), 12, false);
            this.bAB.setIsRound(true);
            this.bAH.setText(com.baidu.live.videochat.d.H(liveVideoBCPanelData.getAnchorNickName(), 16));
            this.bAA.startLoad(liveVideoBCPanelData.getUserPortrait(), 12, false);
            this.bAA.setIsRound(true);
            this.bAG.setText(com.baidu.live.videochat.d.H(liveVideoBCPanelData.getUserNickName(), 16));
        }
    }

    public void startLoading() {
        this.bAC.playAnimation();
    }

    public void stopLoading() {
        this.bAC.cancelAnimation();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.byY = (TextView) getViewGroup().findViewById(a.f.tv_count_down);
        this.bAA = (HeadImageView) getViewGroup().findViewById(a.f.head_user);
        this.bAB = (HeadImageView) getViewGroup().findViewById(a.f.head_anchor);
        this.bAD = (Button) getViewGroup().findViewById(a.f.btn_cancel_apply);
        this.bAC = (TBLottieAnimationView) getViewGroup().findViewById(a.f.loading);
        this.bAH = (TextView) getViewGroup().findViewById(a.f.tv_anchor_name);
        this.bAG = (TextView) getViewGroup().findViewById(a.f.tv_user_name);
        this.bAC.setAnimation("apply_connecting.json");
        this.bAC.loop(true);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        if (cVar != null) {
            this.bAE = cVar;
        }
    }

    private void registerListener() {
        this.bAD.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAD && this.bAE != null) {
            if (this.bAF != null) {
                this.bAF.c(this.bAz);
            }
            this.bAE.dismiss();
        }
    }

    public void a(a aVar) {
        this.bAF = aVar;
    }
}
