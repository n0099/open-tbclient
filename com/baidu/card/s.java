package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int Wt = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
    NEGFeedBackView Wu;

    public s(TbPageContext tbPageContext) {
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Wt, Wt);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds32);
        a(layoutParams);
        this.Wu = new NEGFeedBackView(tbPageContext);
        K(this.Wu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: qH */
    public NEGFeedBackView qF() {
        return this.Wu;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Wu.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null) {
            this.Wu.setVisibility(8);
            return;
        }
        this.Wu.setData(ajVar);
        this.Wu.setFirstRowSingleColumn(true);
        this.Wu.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Wu.onChangeSkinType();
    }
}
