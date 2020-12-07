package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ag extends i {
    private SingleLinkCardView aie;

    public ag(Context context) {
        super(context);
        this.aie = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aie;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.bmn() == null || d(aVar) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bmn().bqY()) && com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqZ()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bmn().bqZ()) && com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqY()) != 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqY()) + com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqZ()) != 1))) {
            this.aie.setVisibility(8);
            return;
        }
        if (aVar.bmn().bqY().size() >= 1) {
            this.aie.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bmn().bqY(), 0));
        } else if (aVar.bmn().bqZ().size() >= 1) {
            this.aie.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bmn().bqZ(), 0));
        }
        this.aie.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aie.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || aVar.bmn().bqX() == null || aVar.bmn().bqX().getOptions() == null || aVar.bmn().bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || !aVar.bmn().bnv() || aVar.bmn().bph() == null) ? false : true;
    }
}
