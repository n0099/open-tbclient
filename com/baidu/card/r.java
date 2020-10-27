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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class r extends at {
    private static final int agk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout agl;
    private TextView agm;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.agm = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.aiw = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.agl = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.aix = tH();
        this.aix.dun().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.at, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        this.agl.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        com.baidu.tieba.play.operableVideoView.b bVar = new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.aiw);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.at, com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        if (this.afI != null && this.afI.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            if (bhz.bks() != null) {
                this.agl.setVisibility(8);
                this.aiw.setVisibility(0);
                this.agm.setVisibility(8);
                super.H(absThreadDataSupport);
                return;
            }
            this.aiw.setVisibility(8);
            this.agl.setVisibility(0);
            this.agm.setVisibility(0);
            this.agl.H(absThreadDataSupport);
            ay.a(this.mTitle, bhz);
            ay.a(this.agm, this.mTitle, bhz, agk);
        }
    }

    @Override // com.baidu.card.at, com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agl, R.drawable.addresslist_item_bg);
            this.agl.onChangeSkinType(this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.agl.setFromCDN(z);
    }
}
