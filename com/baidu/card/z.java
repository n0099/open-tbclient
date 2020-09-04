package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.MultiLinkCardView;
/* loaded from: classes15.dex */
public class z extends h {
    private MultiLinkCardView aga;

    public z(Context context) {
        super(context);
        this.aga = new MultiLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aga;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.bce() == null || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bce().bgK()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bce().bgL()) <= 1) || ((com.baidu.tbadk.core.util.y.isEmpty(absThreadDataSupport.bce().bgL()) && com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bce().bgK()) <= 1) || com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bce().bgK()) + com.baidu.tbadk.core.util.y.getCount(absThreadDataSupport.bce().bgL()) <= 1))) {
            this.aga.setVisibility(8);
            return;
        }
        this.aga.h(absThreadDataSupport.bce().bgK(), absThreadDataSupport.bce().bgL());
        this.aga.setVisibility(0);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aga.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0) ? false : true;
    }
}
