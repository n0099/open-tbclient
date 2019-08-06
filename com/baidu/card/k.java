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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends ac {
    private static final int VU = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout VV;
    private TextView VW;
    private int mSkinType;

    public k(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.VW = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.XC = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.VV = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.XD = qG();
        this.XD.ceg().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ac, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.VV.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qG() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.XC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ac, com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VJ = aVar;
        if (this.VJ != null && this.VJ.acy() != null) {
            bh acy = aVar.acy();
            if (acy.aeP() != null) {
                this.VV.setVisibility(8);
                this.XC.setVisibility(0);
                this.VW.setVisibility(8);
                super.C(aVar);
                return;
            }
            this.XC.setVisibility(8);
            this.VV.setVisibility(0);
            this.VW.setVisibility(0);
            this.VV.C(aVar);
            av.a(this.mTitle, acy);
            av.a(this.VW, this.mTitle, acy, VU);
        }
    }

    @Override // com.baidu.card.ac, com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.VV, R.drawable.addresslist_item_bg);
            this.VV.onChangeSkinType(tbPageContext, this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.VV.setFromCDN(z);
    }
}
