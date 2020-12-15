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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class r extends at {
    private static final int ahn;
    private InterviewLiveLayout aho;
    private TextView ahp;
    private int mSkinType;

    static {
        ahn = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.ahp = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.ajA = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.aho = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.ajB = tK();
        this.ajB.dBI().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.at, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aho.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tK() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ajA);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.at, com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        if (this.agJ != null && this.agJ.bmn() != null) {
            by bmn = aVar.bmn();
            if (bmn.bph() != null) {
                this.aho.setVisibility(8);
                this.ajA.setVisibility(0);
                this.ahp.setVisibility(8);
                super.H(aVar);
                return;
            }
            this.ajA.setVisibility(8);
            this.aho.setVisibility(0);
            this.ahp.setVisibility(0);
            this.aho.H(aVar);
            az.a(this.mTitle, bmn);
            az.a(this.ahp, this.mTitle, bmn, ahn);
        }
    }

    @Override // com.baidu.card.at, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.aho, R.drawable.addresslist_item_bg);
            this.aho.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.aho.setFromCDN(z);
    }
}
