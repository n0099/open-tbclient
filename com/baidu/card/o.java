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
    private static final int adw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout adx;
    private TextView ady;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.ady = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.afy = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.adx = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.afz = rr();
        this.afz.cJq().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.al, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adx.setSubClickListener(zVar);
    }

    @Override // com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.al, com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        if (this.ada != null && this.ada.aIw() != null) {
            bj aIw = aVar.aIw();
            if (aIw.aKV() != null) {
                this.adx.setVisibility(8);
                this.afy.setVisibility(0);
                this.ady.setVisibility(8);
                super.A(aVar);
                return;
            }
            this.afy.setVisibility(8);
            this.adx.setVisibility(0);
            this.ady.setVisibility(0);
            this.adx.A(aVar);
            au.a(this.mTitle, aIw);
            au.a(this.ady, this.mTitle, aIw, adw);
        }
    }

    @Override // com.baidu.card.al, com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.adx, R.drawable.addresslist_item_bg);
            this.adx.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.adx.setFromCDN(z);
    }
}
