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
/* loaded from: classes15.dex */
public class q extends as {
    private static final int afz = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout afA;
    private TextView afB;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.afB = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.ahJ = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.afA = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.ahK = tC();
        this.ahK.djP().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afA.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahJ);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        if (this.aeY != null && this.aeY.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            if (bce.beW() != null) {
                this.afA.setVisibility(8);
                this.ahJ.setVisibility(0);
                this.afB.setVisibility(8);
                super.F(absThreadDataSupport);
                return;
            }
            this.ahJ.setVisibility(8);
            this.afA.setVisibility(0);
            this.afB.setVisibility(0);
            this.afA.F(absThreadDataSupport);
            ay.a(this.mTitle, bce);
            ay.a(this.afB, this.mTitle, bce, afz);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.afA, R.drawable.addresslist_item_bg);
            this.afA.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.afA.setFromCDN(z);
    }
}
