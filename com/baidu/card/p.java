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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class p extends ar {
    private static final int aey = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView aeA;
    private InterviewLiveLayout aez;
    private int mSkinType;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.aeA = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.agI = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.aez = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.agJ = rP();
        this.agJ.cUV().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ar, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aez.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rP() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ar, com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        if (this.aea != null && this.aea.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            if (aPS.aSH() != null) {
                this.aez.setVisibility(8);
                this.agI.setVisibility(0);
                this.aeA.setVisibility(8);
                super.D(absThreadDataSupport);
                return;
            }
            this.agI.setVisibility(8);
            this.aez.setVisibility(0);
            this.aeA.setVisibility(0);
            this.aez.D(absThreadDataSupport);
            aw.a(this.mTitle, aPS);
            aw.a(this.aeA, this.mTitle, aPS, aey);
        }
    }

    @Override // com.baidu.card.ar, com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.an.setBackgroundResource(this.aez, R.drawable.addresslist_item_bg);
            this.aez.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.aez.setFromCDN(z);
    }
}
