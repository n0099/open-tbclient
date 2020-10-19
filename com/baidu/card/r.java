package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class r extends at {
    private static final int agj = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout agk;
    private TextView agl;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.agl = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.aiv = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.agk = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.aiw = tH();
        this.aiw.drg().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.at, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.agk.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiv);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.at, com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        if (this.afH != null && this.afH.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            if (bfG.biz() != null) {
                this.agk.setVisibility(8);
                this.aiv.setVisibility(0);
                this.agl.setVisibility(8);
                super.H(absThreadDataSupport);
                return;
            }
            this.aiv.setVisibility(8);
            this.agk.setVisibility(0);
            this.agl.setVisibility(0);
            this.agk.H(absThreadDataSupport);
            ay.a(this.mTitle, bfG);
            ay.a(this.agl, this.mTitle, bfG, agj);
        }
    }

    @Override // com.baidu.card.at, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agk, R.drawable.addresslist_item_bg);
            this.agk.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.agk.setFromCDN(z);
    }
}
