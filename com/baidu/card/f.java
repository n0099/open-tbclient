package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends c implements p<cb>, q {
    private final CardForumHeadLayout ahL;
    private int topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public f(TbPageContext tbPageContext) {
        this.ahL = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.leftMargin;
        layoutParams.topMargin = this.topMargin;
        layoutParams.bottomMargin = this.bottomMargin;
        a(layoutParams);
        H(this.ahL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(cb cbVar) {
        if (cbVar == null || cbVar.bnS() == null) {
            this.ahL.setVisibility(8);
            return;
        }
        this.ahL.setVisibility(0);
        this.ahL.setData(cbVar);
        this.ahL.setTag(cbVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahL.onChangeSkinType();
    }
}
