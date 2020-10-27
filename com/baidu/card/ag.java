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
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bhz() == null || d(absThreadDataSupport) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bhz().bmg()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bhz().bmh()) != 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bhz().bmh()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bhz().bmg()) != 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bhz().bmg()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bhz().bmh()) != 1))) {
            this.ahc.setVisibility(8);
            return;
        }
        if (absThreadDataSupport.bhz().bmg().size() >= 1) {
            this.ahc.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bhz().bmg(), 0));
        } else if (absThreadDataSupport.bhz().bmh().size() >= 1) {
            this.ahc.a((com.baidu.tieba.card.data.d) com.baidu.tbadk.core.util.y.getItem(absThreadDataSupport.bhz().bmh(), 0));
        }
        this.ahc.setVisibility(0);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahc.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || absThreadDataSupport.bhz().bmf() == null || absThreadDataSupport.bhz().bmf().getOptions() == null || absThreadDataSupport.bhz().bmf().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || !absThreadDataSupport.bhz().biG() || absThreadDataSupport.bhz().bks() == null) ? false : true;
    }
}
