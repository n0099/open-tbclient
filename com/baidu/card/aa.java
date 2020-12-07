package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class aa extends i {
    private MultiLinkCardView ahN;

    public aa(Context context) {
        super(context);
        this.ahN = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.bmn() == null || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bmn().bqY()) && com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqZ()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bmn().bqZ()) && com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqY()) <= 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqY()) + com.baidu.tbadk.core.util.y.getCount(aVar.bmn().bqZ()) <= 1))) {
            this.ahN.setVisibility(8);
            return;
        }
        this.ahN.l(aVar.bmn().bqY(), aVar.bmn().bqZ());
        this.ahN.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahN.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || aVar.bmn().bqX() == null || aVar.bmn().bqX().getOptions() == null || aVar.bmn().bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || !aVar.bmn().bnv() || aVar.bmn().bph() == null) ? false : true;
    }
}
