package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends c implements p<bz>, q {
    private final CardForumHeadLayout ahs;
    private int aht = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int ahu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int ahv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public f(TbPageContext tbPageContext) {
        this.ahs = new CardForumHeadLayout(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.ahu;
        layoutParams.topMargin = this.aht;
        layoutParams.bottomMargin = this.ahv;
        a(layoutParams);
        H(this.ahs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(bz bzVar) {
        if (bzVar == null || bzVar.brq() == null) {
            this.ahs.setVisibility(8);
            return;
        }
        this.ahs.setVisibility(0);
        this.ahs.setData(bzVar);
        this.ahs.setTag(bzVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahs.onChangeSkinType();
    }
}
