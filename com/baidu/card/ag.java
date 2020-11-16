package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ag extends i {
    private SingleLinkCardView ahe;

    public ag(Context context) {
        super(context);
        this.ahe = new SingleLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || aVar == null || aVar.bjd() == null || d(aVar) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bjd().bnK()) && com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnL()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bjd().bnL()) && com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnK()) != 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnK()) + com.baidu.tbadk.core.util.y.getCount(aVar.bjd().bnL()) != 1))) {
            this.ahe.setVisibility(8);
            return;
        }
        if (aVar.bjd().bnK().size() >= 1) {
            this.ahe.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bjd().bnK(), 0));
        } else if (aVar.bjd().bnL().size() >= 1) {
            this.ahe.a((com.baidu.tieba.card.data.c) com.baidu.tbadk.core.util.y.getItem(aVar.bjd().bnL(), 0));
        }
        this.ahe.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahe.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || aVar.bjd().bnJ() == null || aVar.bjd().bnJ().getOptions() == null || aVar.bjd().bnJ().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || !aVar.bjd().bki() || aVar.bjd().blU() == null) ? false : true;
    }
}
