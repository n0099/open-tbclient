package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adw;
    private MutiImgTextLayout aer;
    private String mFrom;
    private int mSkinType;

    public w(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aer = new MutiImgTextLayout(context);
        this.aer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aer;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aer.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.aer.setFrom(this.mFrom);
        this.aer.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        a(1, new a.b() { // from class: com.baidu.card.w.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (w.this.adw != null && w.this.adw.aOi() != null) {
                    com.baidu.tieba.card.m.Dn(w.this.adw.aOi().getId());
                    com.baidu.tieba.card.m.a(w.this.aer.mTitle, w.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(w.this.aer.adV, w.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aer.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aer.setNeedFrsTabName(z);
    }
}
