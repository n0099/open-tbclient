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
    private TextView bEg;
    private LiveVideoBCPanelData bFG;
    private HeadImageView bFH;
    private HeadImageView bFI;
    private TBLottieAnimationView bFJ;
    private Button bFK;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFL;
    private a bFM;
    private TextView bFN;
    private TextView bFO;
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
            this.bFG = liveVideoBCPanelData;
            this.bEg.setText(this.mContext.getString(a.h.talent_count_down) + liveVideoBCPanelData.getDownTime() + "s");
            this.bFI.startLoad(liveVideoBCPanelData.getAnchorPortrait(), 12, false);
            this.bFI.setIsRound(true);
            this.bFO.setText(com.baidu.live.videochat.d.K(liveVideoBCPanelData.getAnchorNickName(), 16));
            this.bFH.startLoad(liveVideoBCPanelData.getUserPortrait(), 12, false);
            this.bFH.setIsRound(true);
            this.bFN.setText(com.baidu.live.videochat.d.K(liveVideoBCPanelData.getUserNickName(), 16));
        }
    }

    public void startLoading() {
        this.bFJ.playAnimation();
    }

    public void stopLoading() {
        this.bFJ.cancelAnimation();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.bEg = (TextView) getViewGroup().findViewById(a.f.tv_count_down);
        this.bFH = (HeadImageView) getViewGroup().findViewById(a.f.head_user);
        this.bFI = (HeadImageView) getViewGroup().findViewById(a.f.head_anchor);
        this.bFK = (Button) getViewGroup().findViewById(a.f.btn_cancel_apply);
        this.bFJ = (TBLottieAnimationView) getViewGroup().findViewById(a.f.loading);
        this.bFO = (TextView) getViewGroup().findViewById(a.f.tv_anchor_name);
        this.bFN = (TextView) getViewGroup().findViewById(a.f.tv_user_name);
        this.bFJ.setAnimation("apply_connecting.json");
        this.bFJ.loop(true);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        if (cVar != null) {
            this.bFL = cVar;
        }
    }

    private void registerListener() {
        this.bFK.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFK && this.bFL != null) {
            if (this.bFM != null) {
                this.bFM.c(this.bFG);
            }
            this.bFL.dismiss();
        }
    }

    public void a(a aVar) {
        this.bFM = aVar;
    }
}
