package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.SingleLinkCardView;
/* loaded from: classes15.dex */
public class ae extends h {
    private SingleLinkCardView aff;

    public ae(Context context) {
        super(context);
        this.aff = new SingleLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aff;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.aTN() == null || com.baidu.tbadk.core.util.x.isEmpty(absThreadDataSupport.aTN().aYr()) || com.baidu.tbadk.core.util.x.getCount(absThreadDataSupport.aTN().aYr()) != 1) {
            this.aff.setVisibility(8);
            return;
        }
        this.aff.a((PbLinkData) com.baidu.tbadk.core.util.x.getItem(absThreadDataSupport.aTN().aYr(), 0));
        this.aff.setVisibility(0);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aff.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.aTN() == null || absThreadDataSupport.aTN().aYq() == null || absThreadDataSupport.aTN().aYq().getOptions() == null || absThreadDataSupport.aTN().aYq().getOptions().size() <= 0) ? false : true;
    }
}
