package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g extends d implements p<bw>, q {
    private final CardForumHeadLayout afR;
    private int topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public g(TbPageContext tbPageContext) {
        this.afR = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.leftMargin;
        layoutParams.topMargin = this.topMargin;
        layoutParams.bottomMargin = this.bottomMargin;
        a(layoutParams);
        H((View) this.afR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        if (bwVar == null || bwVar.bih() == null) {
            this.afR.setVisibility(8);
            return;
        }
        this.afR.setVisibility(0);
        this.afR.setData(bwVar);
        this.afR.setTag(bwVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afR.onChangeSkinType();
    }
}
