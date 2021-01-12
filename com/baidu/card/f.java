package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends c implements p<bz>, q {
    private final CardForumHeadLayout agB;
    private int agC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int agD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int agE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public f(TbPageContext tbPageContext) {
        this.agB = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.agD;
        layoutParams.topMargin = this.agC;
        layoutParams.bottomMargin = this.agE;
        a(layoutParams);
        H(this.agB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(bz bzVar) {
        if (bzVar == null || bzVar.bnx() == null) {
            this.agB.setVisibility(8);
            return;
        }
        this.agB.setVisibility(0);
        this.agB.setData(bzVar);
        this.agB.setTag(bzVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agB.onChangeSkinType();
    }
}
