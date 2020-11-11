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
    private TextView bvz;
    private LiveVideoBCPanelData bxa;
    private HeadImageView bxb;
    private HeadImageView bxc;
    private TBLottieAnimationView bxd;
    private Button bxe;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bxf;
    private a bxg;
    private TextView bxh;
    private TextView bxi;
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
            this.bxa = liveVideoBCPanelData;
            this.bvz.setText(this.mContext.getString(a.h.talent_count_down) + liveVideoBCPanelData.getDownTime() + "s");
            this.bxc.startLoad(liveVideoBCPanelData.getAnchorPortrait(), 12, false);
            this.bxc.setIsRound(true);
            this.bxi.setText(com.baidu.live.videochat.d.G(liveVideoBCPanelData.getAnchorNickName(), 16));
            this.bxb.startLoad(liveVideoBCPanelData.getUserPortrait(), 12, false);
            this.bxb.setIsRound(true);
            this.bxh.setText(com.baidu.live.videochat.d.G(liveVideoBCPanelData.getUserNickName(), 16));
        }
    }

    public void startLoading() {
        this.bxd.playAnimation();
    }

    public void stopLoading() {
        this.bxd.cancelAnimation();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.bvz = (TextView) getViewGroup().findViewById(a.f.tv_count_down);
        this.bxb = (HeadImageView) getViewGroup().findViewById(a.f.head_user);
        this.bxc = (HeadImageView) getViewGroup().findViewById(a.f.head_anchor);
        this.bxe = (Button) getViewGroup().findViewById(a.f.btn_cancel_apply);
        this.bxd = (TBLottieAnimationView) getViewGroup().findViewById(a.f.loading);
        this.bxi = (TextView) getViewGroup().findViewById(a.f.tv_anchor_name);
        this.bxh = (TextView) getViewGroup().findViewById(a.f.tv_user_name);
        this.bxd.setAnimation("apply_connecting.json");
        this.bxd.loop(true);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        if (cVar != null) {
            this.bxf = cVar;
        }
    }

    private void registerListener() {
        this.bxe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bxe && this.bxf != null) {
            if (this.bxg != null) {
                this.bxg.c(this.bxa);
            }
            this.bxf.dismiss();
        }
    }

    public void a(a aVar) {
        this.bxg = aVar;
    }
}
