package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g extends d implements p<by>, q {
    private final CardForumHeadLayout agT;
    private int agU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int agV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int agW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public g(TbPageContext tbPageContext) {
        this.agT = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.agV;
        layoutParams.topMargin = this.agU;
        layoutParams.bottomMargin = this.agW;
        a(layoutParams);
        H((View) this.agT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(by byVar) {
        if (byVar == null || byVar.boP() == null) {
            this.agT.setVisibility(8);
            return;
        }
        this.agT.setVisibility(0);
        this.agT.setData(byVar);
        this.agT.setTag(byVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agT.onChangeSkinType();
    }
}
