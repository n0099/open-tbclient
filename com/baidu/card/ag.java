package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ag extends h {
    private SingleLinkCardView ajf;

    public ag(Context context) {
        super(context);
        this.ajf = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ajf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.blp() == null || d(aVar) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.blp().bqb()) && com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqc()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.blp().bqc()) && com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqb()) != 1) || com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqb()) + com.baidu.tbadk.core.util.y.getCount(aVar.blp().bqc()) != 1))) {
            this.ajf.setVisibility(8);
            return;
        }
        if (aVar.blp().bqb().size() >= 1) {
            this.ajf.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.blp().bqb(), 0));
        } else if (aVar.blp().bqc().size() >= 1) {
            this.ajf.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.blp().bqc(), 0));
        }
        this.ajf.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajf.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || aVar.blp().bqa() == null || aVar.blp().bqa().getOptions() == null || aVar.blp().bqa().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || !aVar.blp().bmx() || aVar.blp().boj() == null) ? false : true;
    }
}
