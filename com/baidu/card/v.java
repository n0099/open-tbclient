package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class v extends f {
    private SmartAppBottomLayout Yk;

    public v(Context context) {
        super(context);
        this.Yk = new SmartAppBottomLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Yk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (this.Yk != null) {
            this.Yk.C(aVar);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Yk != null) {
            this.Yk.onChangeSkinType();
        }
    }
}
