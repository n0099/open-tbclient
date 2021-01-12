package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ah extends h {
    private SmartAppBottomLayout ahZ;

    public ah(Context context) {
        super(context);
        this.ahZ = new SmartAppBottomLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (this.ahZ != null) {
            this.ahZ.C(aVar);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahZ != null) {
            this.ahZ.onChangeSkinType();
        }
    }
}
