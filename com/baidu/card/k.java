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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends ac {
    private static final int XH = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);
    private InterviewLiveLayout XI;
    private TextView XJ;
    private int mSkinType;

    public k(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_seg_title);
        this.XJ = (TextView) this.mRootView.findViewById(d.g.video_seg_abstract);
        this.Zo = (RoundCornerFrameLayout) this.mRootView.findViewById(d.g.frame_video);
        this.XI = (InterviewLiveLayout) this.mRootView.findViewById(d.g.frame_interview_no_video);
        this.Zp = ro();
        this.Zp.bSW().setBackgroundResource(d.C0236d.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ac, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.XI.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a ro() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Zo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ac, com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        if (this.Xx != null && this.Xx.WR() != null) {
            bg WR = aVar.WR();
            if (WR.Zi() != null) {
                this.XI.setVisibility(8);
                this.Zo.setVisibility(0);
                this.XJ.setVisibility(8);
                super.C(aVar);
                return;
            }
            this.Zo.setVisibility(8);
            this.XI.setVisibility(0);
            this.XJ.setVisibility(0);
            this.XI.C(aVar);
            au.a(this.mTitle, WR);
            au.a(this.XJ, this.mTitle, WR, XH);
        }
    }

    @Override // com.baidu.card.ac, com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.XI, d.f.addresslist_item_bg);
            this.XI.onChangeSkinType(tbPageContext, this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.XI.setFromCDN(z);
    }
}
