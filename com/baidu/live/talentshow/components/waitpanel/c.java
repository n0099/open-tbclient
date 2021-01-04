package com.baidu.live.talentshow.components.waitpanel;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<LiveVideoBCPanelData> implements View.OnClickListener {
    private TextView bDM;
    private LiveVideoBCPanelData bFm;
    private HeadImageView bFn;
    private HeadImageView bFo;
    private TBLottieAnimationView bFp;
    private Button bFq;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFr;
    private a bFs;
    private TextView bFt;
    private TextView bFu;
    private Context mContext;

    /* loaded from: classes11.dex */
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
            this.bFm = liveVideoBCPanelData;
            this.bDM.setText(this.mContext.getString(a.h.talent_count_down) + liveVideoBCPanelData.getDownTime() + "s");
            this.bFo.startLoad(liveVideoBCPanelData.getAnchorPortrait(), 12, false);
            this.bFo.setIsRound(true);
            this.bFu.setText(com.baidu.live.videochat.d.J(liveVideoBCPanelData.getAnchorNickName(), 16));
            this.bFn.startLoad(liveVideoBCPanelData.getUserPortrait(), 12, false);
            this.bFn.setIsRound(true);
            this.bFt.setText(com.baidu.live.videochat.d.J(liveVideoBCPanelData.getUserNickName(), 16));
        }
    }

    public void startLoading() {
        this.bFp.playAnimation();
    }

    public void stopLoading() {
        this.bFp.cancelAnimation();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.bDM = (TextView) getViewGroup().findViewById(a.f.tv_count_down);
        this.bFn = (HeadImageView) getViewGroup().findViewById(a.f.head_user);
        this.bFo = (HeadImageView) getViewGroup().findViewById(a.f.head_anchor);
        this.bFq = (Button) getViewGroup().findViewById(a.f.btn_cancel_apply);
        this.bFp = (TBLottieAnimationView) getViewGroup().findViewById(a.f.loading);
        this.bFu = (TextView) getViewGroup().findViewById(a.f.tv_anchor_name);
        this.bFt = (TextView) getViewGroup().findViewById(a.f.tv_user_name);
        this.bFp.setAnimation("apply_connecting.json");
        this.bFp.loop(true);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        if (cVar != null) {
            this.bFr = cVar;
        }
    }

    private void registerListener() {
        this.bFq.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFq && this.bFr != null) {
            if (this.bFs != null) {
                this.bFs.c(this.bFm);
            }
            this.bFr.dismiss();
        }
    }

    public void a(a aVar) {
        this.bFs = aVar;
    }
}
