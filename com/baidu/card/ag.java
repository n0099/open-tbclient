package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class ag extends h {
    private SmartAppBottomLayout agq;

    public ag(Context context) {
        super(context);
        this.agq = new SmartAppBottomLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (this.agq != null) {
            this.agq.F(absThreadDataSupport);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agq != null) {
            this.agq.onChangeSkinType();
        }
    }
}
