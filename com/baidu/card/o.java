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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class o extends al {
    private static final int adz = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout adA;
    private TextView adB;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.adB = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.afB = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.adA = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.afC = rr();
        this.afC.cJn().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.al, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adA.setSubClickListener(zVar);
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.al, com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        if (this.ade != null && this.ade.aIu() != null) {
            bj aIu = aVar.aIu();
            if (aIu.aKT() != null) {
                this.adA.setVisibility(8);
                this.afB.setVisibility(0);
                this.adB.setVisibility(8);
                super.B(aVar);
                return;
            }
            this.afB.setVisibility(8);
            this.adA.setVisibility(0);
            this.adB.setVisibility(0);
            this.adA.B(aVar);
            au.a(this.mTitle, aIu);
            au.a(this.adB, this.mTitle, aIu, adz);
        }
    }

    @Override // com.baidu.card.al, com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.adA, R.drawable.addresslist_item_bg);
            this.adA.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.adA.setFromCDN(z);
    }
}
