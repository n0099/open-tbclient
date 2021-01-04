package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ag extends h {
    private SingleLinkCardView aiQ;

    public ag(Context context) {
        super(context);
        this.aiQ = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.boO() == null || d(aVar) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.boO().btA()) && com.baidu.tbadk.core.util.x.getCount(aVar.boO().btB()) != 1) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.boO().btB()) && com.baidu.tbadk.core.util.x.getCount(aVar.boO().btA()) != 1) || com.baidu.tbadk.core.util.x.getCount(aVar.boO().btA()) + com.baidu.tbadk.core.util.x.getCount(aVar.boO().btB()) != 1))) {
            this.aiQ.setVisibility(8);
            return;
        }
        if (aVar.boO().btA().size() >= 1) {
            this.aiQ.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.x.getItem(aVar.boO().btA(), 0));
        } else if (aVar.boO().btB().size() >= 1) {
            this.aiQ.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.x.getItem(aVar.boO().btB(), 0));
        }
        this.aiQ.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiQ.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || aVar.boO().btz() == null || aVar.boO().btz().getOptions() == null || aVar.boO().btz().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || !aVar.boO().bpV() || aVar.boO().brH() == null) ? false : true;
    }
}
