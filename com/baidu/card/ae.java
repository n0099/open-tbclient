package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.SingleLinkCardView;
/* loaded from: classes8.dex */
public class ae extends h {
    private SingleLinkCardView afo;

    public ae(Context context) {
        super(context);
        this.afo = new SingleLinkCardView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (c(absThreadDataSupport) || absThreadDataSupport == null || absThreadDataSupport.aPS() == null || com.baidu.tbadk.core.util.w.isEmpty(absThreadDataSupport.aPS().aUx()) || com.baidu.tbadk.core.util.w.getCount(absThreadDataSupport.aPS().aUx()) != 1) {
            this.afo.setVisibility(8);
            return;
        }
        this.afo.a((PbLinkData) com.baidu.tbadk.core.util.w.getItem(absThreadDataSupport.aPS().aUx(), 0));
        this.afo.setVisibility(0);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afo.onChangeSkinType();
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.aPS() == null || absThreadDataSupport.aPS().aUw() == null || absThreadDataSupport.aPS().aUw().getOptions() == null || absThreadDataSupport.aPS().aUw().getOptions().size() <= 0) ? false : true;
    }
}
