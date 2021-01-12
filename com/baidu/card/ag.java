package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ag extends h {
    private SingleLinkCardView ahY;

    public ag(Context context) {
        super(context);
        this.ahY = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.bkV() == null || d(aVar) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.bkV().bpH()) && com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpI()) != 1) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.bkV().bpI()) && com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpH()) != 1) || com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpH()) + com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpI()) != 1))) {
            this.ahY.setVisibility(8);
            return;
        }
        if (aVar.bkV().bpH().size() >= 1) {
            this.ahY.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.x.getItem(aVar.bkV().bpH(), 0));
        } else if (aVar.bkV().bpI().size() >= 1) {
            this.ahY.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.x.getItem(aVar.bkV().bpI(), 0));
        }
        this.ahY.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahY.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || aVar.bkV().bpG() == null || aVar.bkV().bpG().getOptions() == null || aVar.bkV().bpG().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || !aVar.bkV().bmc() || aVar.bkV().bnO() == null) ? false : true;
    }
}
