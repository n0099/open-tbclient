package com.baidu.live.talentshow.components.waitpanel;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<LiveVideoBCPanelData> implements View.OnClickListener {
    private LiveVideoBCPanelData bAA;
    private HeadImageView bAB;
    private HeadImageView bAC;
    private TBLottieAnimationView bAD;
    private Button bAE;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAF;
    private a bAG;
    private TextView bAH;
    private TextView bAI;
    private TextView bza;
    private Context mContext;

    /* loaded from: classes10.dex */
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
            this.bAA = liveVideoBCPanelData;
            this.bza.setText(this.mContext.getString(a.h.talent_count_down) + liveVideoBCPanelData.getDownTime() + "s");
            this.bAC.startLoad(liveVideoBCPanelData.getAnchorPortrait(), 12, false);
            this.bAC.setIsRound(true);
            this.bAI.setText(com.baidu.live.videochat.d.J(liveVideoBCPanelData.getAnchorNickName(), 16));
            this.bAB.startLoad(liveVideoBCPanelData.getUserPortrait(), 12, false);
            this.bAB.setIsRound(true);
            this.bAH.setText(com.baidu.live.videochat.d.J(liveVideoBCPanelData.getUserNickName(), 16));
        }
    }

    public void startLoading() {
        this.bAD.playAnimation();
    }

    public void stopLoading() {
        this.bAD.cancelAnimation();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.bza = (TextView) getViewGroup().findViewById(a.f.tv_count_down);
        this.bAB = (HeadImageView) getViewGroup().findViewById(a.f.head_user);
        this.bAC = (HeadImageView) getViewGroup().findViewById(a.f.head_anchor);
        this.bAE = (Button) getViewGroup().findViewById(a.f.btn_cancel_apply);
        this.bAD = (TBLottieAnimationView) getViewGroup().findViewById(a.f.loading);
        this.bAI = (TextView) getViewGroup().findViewById(a.f.tv_anchor_name);
        this.bAH = (TextView) getViewGroup().findViewById(a.f.tv_user_name);
        this.bAD.setAnimation("apply_connecting.json");
        this.bAD.loop(true);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        if (cVar != null) {
            this.bAF = cVar;
        }
    }

    private void registerListener() {
        this.bAE.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAE && this.bAF != null) {
            if (this.bAG != null) {
                this.bAG.c(this.bAA);
            }
            this.bAF.dismiss();
        }
    }

    public void a(a aVar) {
        this.bAG = aVar;
    }
}
