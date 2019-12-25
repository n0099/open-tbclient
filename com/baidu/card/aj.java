package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class aj extends d implements m<bj>, n {
    private static final int LV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    private UnfollowedDecorView LW;

    public aj(TbPageContext tbPageContext, boolean z) {
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LV, LV);
        layoutParams.addRule(11);
        if (z) {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        a(layoutParams);
        c(tbPageContext);
    }

    private void c(TbPageContext tbPageContext) {
        this.LW = new UnfollowedDecorView(tbPageContext.getPageActivity());
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.LW.setPadding(dimens, dimens, dimens, dimens);
        F(this.LW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.LW.q(bjVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.LW.onChangeSkinType();
    }
}
