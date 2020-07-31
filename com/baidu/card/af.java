package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class af extends h {
    private SmartAppBottomLayout afg;

    public af(Context context) {
        super(context);
        this.afg = new SmartAppBottomLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (this.afg != null) {
            this.afg.D(absThreadDataSupport);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afg != null) {
            this.afg.onChangeSkinType();
        }
    }
}
