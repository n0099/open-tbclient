package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleHorizontalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class v extends b<AbsThreadDataSupport> {
    private MutiImgSingleHorizontalLayout aeU;
    private AbsThreadDataSupport aea;
    private String mFrom;
    private int mSkinType;

    public v(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeU = new MutiImgSingleHorizontalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeU;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeU.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aeU.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
    }

    public void setFromCDN(boolean z) {
        this.aeU.setFromCDN(z);
    }
}
