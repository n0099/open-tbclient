package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class g extends d implements p<bw>, q {
    private final CardForumHeadLayout afA;
    private int topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public g(TbPageContext tbPageContext) {
        this.afA = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.leftMargin;
        layoutParams.topMargin = this.topMargin;
        layoutParams.bottomMargin = this.bottomMargin;
        a(layoutParams);
        H(this.afA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bw bwVar) {
        if (bwVar == null || bwVar.bfy() == null) {
            this.afA.setVisibility(8);
            return;
        }
        this.afA.setVisibility(0);
        this.afA.setData(bwVar);
        this.afA.setTag(bwVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afA.onChangeSkinType();
    }
}
