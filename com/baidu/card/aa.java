package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends h {
    private MultiLinkCardView ahI;

    public aa(Context context) {
        super(context);
        this.ahI = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.bkV() == null || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.bkV().bpH()) && com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpI()) <= 1) || ((com.baidu.tbadk.core.util.x.isEmpty(aVar.bkV().bpI()) && com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpH()) <= 1) || com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpH()) + com.baidu.tbadk.core.util.x.getCount(aVar.bkV().bpI()) <= 1))) {
            this.ahI.setVisibility(8);
            return;
        }
        this.ahI.n(aVar.bkV().bpH(), aVar.bkV().bpI());
        this.ahI.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahI.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || aVar.bkV().bpG() == null || aVar.bkV().bpG().getOptions() == null || aVar.bkV().bpG().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || !aVar.bkV().bmc() || aVar.bkV().bnO() == null) ? false : true;
    }
}
