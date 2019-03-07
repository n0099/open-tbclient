package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int Yg = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds115);
    NEGFeedBackView Yh;

    public s(TbPageContext tbPageContext) {
        bx(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Yg, Yg);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds32);
        a(layoutParams);
        this.Yh = new NEGFeedBackView(tbPageContext);
        I(this.Yh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: rp */
    public NEGFeedBackView getDecorView() {
        return this.Yh;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Yh.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null) {
            this.Yh.setVisibility(8);
            return;
        }
        this.Yh.setData(ajVar);
        this.Yh.setFirstRowSingleColumn(true);
        this.Yh.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Yh.onChangeSkinType();
    }
}
