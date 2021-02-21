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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class r extends as {
    private static final int agW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private InterviewLiveLayout agX;
    private TextView agY;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.agY = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.agA = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.agX = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.ajd = sU();
        this.ajd.dzW().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.as, com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.agX.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.agA);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.as, com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        if (this.agj != null && this.agj.bln() != null) {
            cb bln = aVar.bln();
            if (bln.boh() != null) {
                this.agX.setVisibility(8);
                this.agA.setVisibility(0);
                this.agY.setVisibility(8);
                super.C(aVar);
                return;
            }
            this.agA.setVisibility(8);
            this.agX.setVisibility(0);
            this.agY.setVisibility(0);
            this.agX.C(aVar);
            az.a(this.mTitle, bln);
            az.a(this.agY, this.mTitle, bln, agW);
        }
    }

    @Override // com.baidu.card.as, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agX, R.drawable.addresslist_item_bg);
            this.agX.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.agX.setFromCDN(z);
    }
}
