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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class r extends as {
    private static final int ahh = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private InterviewLiveLayout ahi;
    private TextView ahj;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.ahj = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.agL = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.ahi = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.ajp = sX();
        this.ajp.dxG().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahi.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sX() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agL);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        if (this.agr != null && this.agr.bkV() != null) {
            bz bkV = aVar.bkV();
            if (bkV.bnO() != null) {
                this.ahi.setVisibility(8);
                this.agL.setVisibility(0);
                this.ahj.setVisibility(8);
                super.C(aVar);
                return;
            }
            this.agL.setVisibility(8);
            this.ahi.setVisibility(0);
            this.ahj.setVisibility(0);
            this.ahi.C(aVar);
            ay.a(this.mTitle, bkV);
            ay.a(this.ahj, this.mTitle, bkV, ahh);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ahi, R.drawable.addresslist_item_bg);
            this.ahi.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.ahi.setFromCDN(z);
    }
}
