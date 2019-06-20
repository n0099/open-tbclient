package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int VY = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
    NEGFeedBackView VZ;

    public s(TbPageContext tbPageContext) {
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VY, VY);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds32);
        a(layoutParams);
        this.VZ = new NEGFeedBackView(tbPageContext);
        I(this.VZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: qk */
    public NEGFeedBackView getDecorView() {
        return this.VZ;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.VZ.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null) {
            this.VZ.setVisibility(8);
            return;
        }
        this.VZ.setData(ajVar);
        this.VZ.setFirstRowSingleColumn(true);
        this.VZ.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VZ.onChangeSkinType();
    }
}
