package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int Ws = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
    NEGFeedBackView Wt;

    public s(TbPageContext tbPageContext) {
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Ws, Ws);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds32);
        a(layoutParams);
        this.Wt = new NEGFeedBackView(tbPageContext);
        K(this.Wt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: qI */
    public NEGFeedBackView qG() {
        return this.Wt;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Wt.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null) {
            this.Wt.setVisibility(8);
            return;
        }
        this.Wt.setData(ajVar);
        this.Wt.setFirstRowSingleColumn(true);
        this.Wt.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Wt.onChangeSkinType();
    }
}
