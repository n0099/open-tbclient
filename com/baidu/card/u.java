package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.ShareSmartAppLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class u extends f {
    private ShareSmartAppLayout Yi;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Yi = new ShareSmartAppLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Yi;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Yi.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Yi.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.Yi.aaG.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    public void setFromCDN(boolean z) {
        this.Yi.setFromCDN(z);
    }
}
