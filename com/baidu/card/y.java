package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class y extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    public MutiImgSingleVerticalLayout aiw;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aiw = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aiw;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.aiw.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.aiw.setFrom(this.mFrom);
        this.aiw.D(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.y.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (y.this.ahi != null && y.this.ahi.boO() != null) {
                    com.baidu.tieba.card.m.Jo(y.this.ahi.boO().getId());
                    com.baidu.tieba.card.m.a(y.this.aiw.mTitle, y.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(y.this.aiw.aia, y.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aiw.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aiw.setNeedFrsTabName(z);
    }
}
