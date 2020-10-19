package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.SingleLinkCardView;
/* loaded from: classes21.dex */
public class ag extends i {
    private SingleLinkCardView ahb;

    public ag(Context context) {
        super(context);
        this.ahb = new SingleLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bfG() == null || d(absThreadDataSupport) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bfG().bkn()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bko()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bfG().bko()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bkn()) != 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bkn()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bfG().bko()) != 1))) {
            this.ahb.setVisibility(8);
            return;
        }
        if (absThreadDataSupport.bfG().bkn().size() >= 1) {
            this.ahb.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bfG().bkn(), 0));
        } else if (absThreadDataSupport.bfG().bko().size() >= 1) {
            this.ahb.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bfG().bko(), 0));
        }
        this.ahb.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahb.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().bkm() == null || absThreadDataSupport.bfG().bkm().getOptions() == null || absThreadDataSupport.bfG().bkm().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || !absThreadDataSupport.bfG().bgN() || absThreadDataSupport.bfG().biz() == null) ? false : true;
    }
}
