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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends ac {
    private static final int FI = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout FJ;
    private TextView FK;
    private int mSkinType;

    public k(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.FK = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.Hv = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.FJ = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.Hw = lM();
        this.Hw.cbX().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ac, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.FJ.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Hv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ac, com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        if (this.Fx != null && this.Fx.agI() != null) {
            bh agI = aVar.agI();
            if (agI.aiX() != null) {
                this.FJ.setVisibility(8);
                this.Hv.setVisibility(0);
                this.FK.setVisibility(8);
                super.z(aVar);
                return;
            }
            this.Hv.setVisibility(8);
            this.FJ.setVisibility(0);
            this.FK.setVisibility(0);
            this.FJ.z(aVar);
            au.a(this.mTitle, agI);
            au.a(this.FK, this.mTitle, agI, FI);
        }
    }

    @Override // com.baidu.card.ac, com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.FJ, R.drawable.addresslist_item_bg);
            this.FJ.onChangeSkinType(tbPageContext, this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.FJ.setFromCDN(z);
    }
}
