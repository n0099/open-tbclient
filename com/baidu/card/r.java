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
    private static final int ahY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private InterviewLiveLayout ahZ;
    private TextView aia;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.aia = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.ahC = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.ahZ = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.akg = ti();
        this.akg.dBy().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ahZ.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a ti() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahC);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        if (this.ahi != null && this.ahi.boP() != null) {
            bz boP = aVar.boP();
            if (boP.brI() != null) {
                this.ahZ.setVisibility(8);
                this.ahC.setVisibility(0);
                this.aia.setVisibility(8);
                super.D(aVar);
                return;
            }
            this.ahC.setVisibility(8);
            this.ahZ.setVisibility(0);
            this.aia.setVisibility(0);
            this.ahZ.D(aVar);
            ay.a(this.mTitle, boP);
            ay.a(this.aia, this.mTitle, boP, ahY);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ahZ, R.drawable.addresslist_item_bg);
            this.ahZ.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.ahZ.setFromCDN(z);
    }
}
