package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends h {
    private MultiLinkCardView ahw;

    public aa(Context context) {
        super(context);
        this.ahw = new MultiLinkCardView(context);
        setTopMargin(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (c(aVar) || d(aVar) || aVar == null || aVar.bln() == null || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bln().bpZ()) && com.baidu.tbadk.core.util.y.getCount(aVar.bln().bqa()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(aVar.bln().bqa()) && com.baidu.tbadk.core.util.y.getCount(aVar.bln().bpZ()) <= 1) || com.baidu.tbadk.core.util.y.getCount(aVar.bln().bpZ()) + com.baidu.tbadk.core.util.y.getCount(aVar.bln().bqa()) <= 1))) {
            this.ahw.setVisibility(8);
            return;
        }
        this.ahw.m(aVar.bln().bpZ(), aVar.bln().bqa());
        this.ahw.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahw.onChangeSkinType();
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || aVar.bln().bpY() == null || aVar.bln().bpY().getOptions() == null || aVar.bln().bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || !aVar.bln().bmv() || aVar.bln().boh() == null) ? false : true;
    }
}
