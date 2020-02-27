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
    private static final int Ky = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView KA;
    private InterviewLiveLayout Kz;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.KA = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.MK = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.Kz = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.MN = mZ();
        this.MN.cyp().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.al, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Kz.setSubClickListener(zVar);
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.MK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.al, com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        if (this.Kc != null && this.Kc.aAe() != null) {
            bj aAe = aVar.aAe();
            if (aAe.aCD() != null) {
                this.Kz.setVisibility(8);
                this.MK.setVisibility(0);
                this.KA.setVisibility(8);
                super.A(aVar);
                return;
            }
            this.MK.setVisibility(8);
            this.Kz.setVisibility(0);
            this.KA.setVisibility(0);
            this.Kz.A(aVar);
            au.a(this.mTitle, aAe);
            au.a(this.KA, this.mTitle, aAe, Ky);
        }
    }

    @Override // com.baidu.card.al, com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.Kz, R.drawable.addresslist_item_bg);
            this.Kz.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.Kz.setFromCDN(z);
    }
}
