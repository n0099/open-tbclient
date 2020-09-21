package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.SingleLinkCardView;
/* loaded from: classes20.dex */
public class ag extends i {
    private SingleLinkCardView agK;

    public ag(Context context) {
        super(context);
        this.agK = new SingleLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bcY() == null || d(absThreadDataSupport) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bcY().bhE()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhF()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bcY().bhF()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhE()) != 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhE()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bcY().bhF()) != 1))) {
            this.agK.setVisibility(8);
            return;
        }
        if (absThreadDataSupport.bcY().bhE().size() >= 1) {
            this.agK.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bcY().bhE(), 0));
        } else if (absThreadDataSupport.bcY().bhF().size() >= 1) {
            this.agK.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bcY().bhF(), 0));
        }
        this.agK.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agK.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bhD() == null || absThreadDataSupport.bcY().bhD().getOptions() == null || absThreadDataSupport.bcY().bhD().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || !absThreadDataSupport.bcY().bee() || absThreadDataSupport.bcY().bfQ() == null) ? false : true;
    }
}
