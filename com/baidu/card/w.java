package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class w extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    public MutiImgSingleVerticalLayout aeL;
    private String mFrom;
    private int mSkinType;

    public w(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeL = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeL;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeL.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.aeL.setFrom(this.mFrom);
        this.aeL.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, new a.b() { // from class: com.baidu.card.w.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (w.this.adQ != null && w.this.adQ.aTN() != null) {
                    com.baidu.tieba.card.m.Ez(w.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(w.this.aeL.mTitle, w.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(w.this.aeL.aeq, w.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aeL.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeL.setNeedFrsTabName(z);
    }
}
