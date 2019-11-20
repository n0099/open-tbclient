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
    private static final int Fi = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout Fj;
    private TextView Fk;
    private int mSkinType;

    public k(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.Fk = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.GV = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.Fj = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.GW = lM();
        this.GW.cbV().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ac, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Fj.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a lM() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.GV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ac, com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        if (this.EX != null && this.EX.agG() != null) {
            bh agG = aVar.agG();
            if (agG.aiV() != null) {
                this.Fj.setVisibility(8);
                this.GV.setVisibility(0);
                this.Fk.setVisibility(8);
                super.z(aVar);
                return;
            }
            this.GV.setVisibility(8);
            this.Fj.setVisibility(0);
            this.Fk.setVisibility(0);
            this.Fj.z(aVar);
            au.a(this.mTitle, agG);
            au.a(this.Fk, this.mTitle, agG, Fi);
        }
    }

    @Override // com.baidu.card.ac, com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.Fj, R.drawable.addresslist_item_bg);
            this.Fj.onChangeSkinType(tbPageContext, this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.Fj.setFromCDN(z);
    }
}
