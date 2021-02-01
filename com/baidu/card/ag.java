package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ag extends h {
    private SingleLinkCardView ahM;

    public ag(Context context) {
        super(context);
        this.ahM = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.bln() == null || d(aVar) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bln().bpZ()) && com.baidu.tbadk.core.util.y.getCount(aVar.bln().bqa()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bln().bqa()) && com.baidu.tbadk.core.util.y.getCount(aVar.bln().bpZ()) != 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bln().bpZ()) + com.baidu.tbadk.core.util.y.getCount(aVar.bln().bqa()) != 1))) {
            this.ahM.setVisibility(8);
            return;
        }
        if (aVar.bln().bpZ().size() >= 1) {
            this.ahM.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bln().bpZ(), 0));
        } else if (aVar.bln().bqa().size() >= 1) {
            this.ahM.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bln().bqa(), 0));
        }
        this.ahM.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahM.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || aVar.bln().bpY() == null || aVar.bln().bpY().getOptions() == null || aVar.bln().bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || !aVar.bln().bmv() || aVar.bln().boh() == null) ? false : true;
    }
}
