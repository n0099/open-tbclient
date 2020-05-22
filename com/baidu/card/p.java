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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class p extends am {
    private static final int adT = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout adU;
    private TextView adV;
    private int mSkinType;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.adV = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.afX = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.adU = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.afY = ry();
        this.afY.cQn().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.am, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.adU.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.afX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.am, com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        if (this.adw != null && this.adw.aOi() != null) {
            bk aOi = absThreadDataSupport.aOi();
            if (aOi.aQQ() != null) {
                this.adU.setVisibility(8);
                this.afX.setVisibility(0);
                this.adV.setVisibility(8);
                super.D(absThreadDataSupport);
                return;
            }
            this.afX.setVisibility(8);
            this.adU.setVisibility(0);
            this.adV.setVisibility(0);
            this.adU.D(absThreadDataSupport);
            au.a(this.mTitle, aOi);
            au.a(this.adV, this.mTitle, aOi, adT);
        }
    }

    @Override // com.baidu.card.am, com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.adU, R.drawable.addresslist_item_bg);
            this.adU.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.adU.setFromCDN(z);
    }
}
