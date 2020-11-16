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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class r extends at {
    private static final int agp;
    private InterviewLiveLayout agq;
    private TextView agr;
    private int mSkinType;

    static {
        agp = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.agr = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.aiB = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.agq = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.aiC = tH();
        this.aiC.dwp().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.at, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.agq.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiB);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.at, com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        if (this.afN != null && this.afN.bjd() != null) {
            bx bjd = aVar.bjd();
            if (bjd.blU() != null) {
                this.agq.setVisibility(8);
                this.aiB.setVisibility(0);
                this.agr.setVisibility(8);
                super.H(aVar);
                return;
            }
            this.aiB.setVisibility(8);
            this.agq.setVisibility(0);
            this.agr.setVisibility(0);
            this.agq.H(aVar);
            az.a(this.mTitle, bjd);
            az.a(this.agr, this.mTitle, bjd, agp);
        }
    }

    @Override // com.baidu.card.at, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agq, R.drawable.addresslist_item_bg);
            this.agq.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.agq.setFromCDN(z);
    }
}
