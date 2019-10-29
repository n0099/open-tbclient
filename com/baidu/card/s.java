package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int Gi = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
    NEGFeedBackView Gj;

    public s(TbPageContext tbPageContext) {
        aE(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Gi, Gi);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds32);
        a(layoutParams);
        this.Gj = new NEGFeedBackView(tbPageContext);
        F(this.Gj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: lN */
    public NEGFeedBackView lL() {
        return this.Gj;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Gj.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(aj ajVar) {
        if (ajVar == null) {
            this.Gj.setVisibility(8);
            return;
        }
        this.Gj.setData(ajVar);
        this.Gj.setFirstRowSingleColumn(true);
        this.Gj.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Gj.onChangeSkinType();
    }
}
