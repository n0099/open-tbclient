package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends h {
    private MultiLinkCardView aiA;

    public aa(Context context) {
        super(context);
        this.aiA = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.boO() == null || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.boO().btA()) && com.baidu.tbadk.core.util.x.getCount(aVar.boO().btB()) <= 1) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.boO().btB()) && com.baidu.tbadk.core.util.x.getCount(aVar.boO().btA()) <= 1) || com.baidu.tbadk.core.util.x.getCount(aVar.boO().btA()) + com.baidu.tbadk.core.util.x.getCount(aVar.boO().btB()) <= 1))) {
            this.aiA.setVisibility(8);
            return;
        }
        this.aiA.n(aVar.boO().btA(), aVar.boO().btB());
        this.aiA.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiA.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || aVar.boO().btz() == null || aVar.boO().btz().getOptions() == null || aVar.boO().btz().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || !aVar.boO().bpV() || aVar.boO().brH() == null) ? false : true;
    }
}
