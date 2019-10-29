package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleHorizontalLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class p extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Fx;
    private MutiImgSingleHorizontalLayout Gd;
    private String mFrom;
    private int mSkinType;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Gd = new MutiImgSingleHorizontalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Gd;
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Gd.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        this.Gd.z(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
    }

    public void setFromCDN(boolean z) {
        this.Gd.setFromCDN(z);
    }
}
