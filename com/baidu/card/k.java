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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends ac {
    private static final int VA = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private InterviewLiveLayout VB;
    private TextView VC;
    private int mSkinType;

    public k(Context context) {
        super(context);
        this.mSkinType = 3;
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
        this.VC = (TextView) this.mRootView.findViewById(R.id.video_seg_abstract);
        this.Xi = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
        this.VB = (InterviewLiveLayout) this.mRootView.findViewById(R.id.frame_interview_no_video);
        this.Xj = qj();
        this.Xj.caV().setBackgroundResource(R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.ac, com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.VB.setSubClickListener(abVar);
    }

    @Override // com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        return new com.baidu.tieba.play.operableVideoView.b(this.mContext, this.Xi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.ac, com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        if (this.Vq != null && this.Vq.abv() != null) {
            bg abv = aVar.abv();
            if (abv.adM() != null) {
                this.VB.setVisibility(8);
                this.Xi.setVisibility(0);
                this.VC.setVisibility(8);
                super.C(aVar);
                return;
            }
            this.Xi.setVisibility(8);
            this.VB.setVisibility(0);
            this.VC.setVisibility(0);
            this.VB.C(aVar);
            au.a(this.mTitle, abv);
            au.a(this.VC, this.mTitle, abv, VA);
        }
    }

    @Override // com.baidu.card.ac, com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.VB, R.drawable.addresslist_item_bg);
            this.VB.onChangeSkinType(tbPageContext, this.mSkinType);
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.VB.setFromCDN(z);
    }
}
