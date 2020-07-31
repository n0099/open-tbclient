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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class p extends ar {
    private static final int aeo = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout aep;
    private TextView aeq;
    private int mSkinType;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.aeq = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.agz = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.aep = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.agA = rR();
        this.agA.cYJ().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ar, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aep.setSubClickListener(aaVar);
    }

    @Override // com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rR() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ar, com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        if (this.adQ != null && this.adQ.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            if (aTN.aWD() != null) {
                this.aep.setVisibility(8);
                this.agz.setVisibility(0);
                this.aeq.setVisibility(8);
                super.D(absThreadDataSupport);
                return;
            }
            this.agz.setVisibility(8);
            this.aep.setVisibility(0);
            this.aeq.setVisibility(0);
            this.aep.D(absThreadDataSupport);
            ax.a(this.mTitle, aTN);
            ax.a(this.aeq, this.mTitle, aTN, aeo);
        }
    }

    @Override // com.baidu.card.ar, com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.aep, R.drawable.addresslist_item_bg);
            this.aep.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.aep.setFromCDN(z);
    }
}
