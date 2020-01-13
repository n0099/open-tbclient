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
/* loaded from: classes6.dex */
public class o extends al {
    private static final int Kc = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout Ke;
    private TextView Kf;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.Kf = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.Mk = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.Ke = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.Ml = mK();
        this.Ml.cwU().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.al, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Ke.setSubClickListener(zVar);
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Mk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.al, com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        if (this.JH != null && this.JH.axQ() != null) {
            bj axQ = aVar.axQ();
            if (axQ.aAo() != null) {
                this.Ke.setVisibility(8);
                this.Mk.setVisibility(0);
                this.Kf.setVisibility(8);
                super.A(aVar);
                return;
            }
            this.Mk.setVisibility(8);
            this.Ke.setVisibility(0);
            this.Kf.setVisibility(0);
            this.Ke.A(aVar);
            au.a(this.mTitle, axQ);
            au.a(this.Kf, this.mTitle, axQ, Kc);
        }
    }

    @Override // com.baidu.card.al, com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.Ke, R.drawable.addresslist_item_bg);
            this.Ke.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.Ke.setFromCDN(z);
    }
}
