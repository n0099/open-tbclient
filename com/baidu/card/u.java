package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class u extends f {
    private SmartAppBottomLayout Wa;

    public u(Context context) {
        super(context);
        this.Wa = new SmartAppBottomLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Wa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (this.Wa != null) {
            this.Wa.C(aVar);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Wa != null) {
            this.Wa.onChangeSkinType();
        }
    }
}
