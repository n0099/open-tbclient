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
/* loaded from: classes20.dex */
public class r extends at {
    private static final int afR = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout afS;
    private TextView afT;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.afT = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.aie = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.afS = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.aif = tH();
        this.aif.dnv().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.at, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afS.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aie);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.at, com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        if (this.afq != null && this.afq.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            if (bcY.bfQ() != null) {
                this.afS.setVisibility(8);
                this.aie.setVisibility(0);
                this.afT.setVisibility(8);
                super.G(absThreadDataSupport);
                return;
            }
            this.aie.setVisibility(8);
            this.afS.setVisibility(0);
            this.afT.setVisibility(0);
            this.afS.G(absThreadDataSupport);
            ay.a(this.mTitle, bcY);
            ay.a(this.afT, this.mTitle, bcY, afR);
        }
    }

    @Override // com.baidu.card.at, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.afS, R.drawable.addresslist_item_bg);
            this.afS.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.afS.setFromCDN(z);
    }
}
