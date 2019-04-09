package com.baidu.card;

import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class s extends c implements i<aj>, j {
    private static final int Yi = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds115);
    NEGFeedBackView Yj;

    public s(TbPageContext tbPageContext) {
        bw(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Yi, Yi);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds32);
        a(layoutParams);
        this.Yj = new NEGFeedBackView(tbPageContext);
        I(this.Yj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.c
    /* renamed from: rp */
    public NEGFeedBackView getDecorView() {
        return this.Yj;
    }

    public void a(NEGFeedBackView.a aVar) {
        this.Yj.setEventCallback(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null) {
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setData(ajVar);
        this.Yj.setFirstRowSingleColumn(true);
        this.Yj.setVisibility(0);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Yj.onChangeSkinType();
    }
}
