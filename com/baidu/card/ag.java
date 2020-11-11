package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.SingleLinkCardView;
/* loaded from: classes21.dex */
public class ag extends i {
    private SingleLinkCardView ahc;

    public ag(Context context) {
        super(context);
        this.ahc = new SingleLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bjZ() == null || d(absThreadDataSupport) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bjZ().boG()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bjZ().boH()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bjZ().boH()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bjZ().boG()) != 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bjZ().boG()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bjZ().boH()) != 1))) {
            this.ahc.setVisibility(8);
            return;
        }
        if (absThreadDataSupport.bjZ().boG().size() >= 1) {
            this.ahc.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bjZ().boG(), 0));
        } else if (absThreadDataSupport.bjZ().boH().size() >= 1) {
            this.ahc.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bjZ().boH(), 0));
        }
        this.ahc.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahc.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bjZ() == null || absThreadDataSupport.bjZ().boF() == null || absThreadDataSupport.bjZ().boF().getOptions() == null || absThreadDataSupport.bjZ().boF().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bjZ() == null || !absThreadDataSupport.bjZ().blg() || absThreadDataSupport.bjZ().bmS() == null) ? false : true;
    }
}
