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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class r extends as {
    private static final int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private InterviewLiveLayout aiq;
    private TextView air;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.air = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.ahS = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.aiq = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.akv = sU();
        this.akv.dAf().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aiq.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahS);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        if (this.ahB != null && this.ahB.blp() != null) {
            cb blp = aVar.blp();
            if (blp.boj() != null) {
                this.aiq.setVisibility(8);
                this.ahS.setVisibility(0);
                this.air.setVisibility(8);
                super.E(aVar);
                return;
            }
            this.ahS.setVisibility(8);
            this.aiq.setVisibility(0);
            this.air.setVisibility(0);
            this.aiq.E(aVar);
            az.a(this.mTitle, blp);
            az.a(this.air, this.mTitle, blp, aip);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.aiq, R.drawable.addresslist_item_bg);
            this.aiq.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.aiq.setFromCDN(z);
    }
}
