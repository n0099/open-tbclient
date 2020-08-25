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
    private static final int afx = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout afy;
    private TextView afz;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.afz = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.ahH = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.afy = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.ahI = tC();
        this.ahI.djM().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afy.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.ahH);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        if (this.aeW != null && this.aeW.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            if (bce.beW() != null) {
                this.afy.setVisibility(8);
                this.ahH.setVisibility(0);
                this.afz.setVisibility(8);
                super.F(absThreadDataSupport);
                return;
            }
            this.ahH.setVisibility(8);
            this.afy.setVisibility(0);
            this.afz.setVisibility(0);
            this.afy.F(absThreadDataSupport);
            ay.a(this.mTitle, bce);
            ay.a(this.afz, this.mTitle, bce, afx);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.afy, R.drawable.addresslist_item_bg);
            this.afy.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.afy.setFromCDN(z);
    }
}
