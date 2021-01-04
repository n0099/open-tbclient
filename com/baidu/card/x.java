package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleHorizontalLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class x extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    private MutiImgSingleHorizontalLayout aiv;
    private String mFrom;
    private int mSkinType;

    public x(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aiv = new MutiImgSingleHorizontalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiv;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.aiv.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.aiv.D(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
    }

    public void setFromCDN(boolean z) {
        this.aiv.setFromCDN(z);
    }
}
