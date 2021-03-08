package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends h {
    private MultiLinkCardView aiP;

    public aa(Context context) {
        super(context);
        this.aiP = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.blp() == null || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.blp().bqb()) && com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqc()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.blp().bqc()) && com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqb()) <= 1) || com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqb()) + com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqc()) <= 1))) {
            this.aiP.setVisibility(8);
            return;
        }
        this.aiP.l(aVar.blp().bqb(), aVar.blp().bqc());
        this.aiP.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiP.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || aVar.blp().bqa() == null || aVar.blp().bqa().getOptions() == null || aVar.blp().bqa().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || !aVar.blp().bmx() || aVar.blp().boj() == null) ? false : true;
    }
}
