package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class s extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adw;
    private MutiImgMutiPicLayout aek;
    private String mFrom;
    private int mSkinType;

    public s(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aek = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aek;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aek.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.aek.setFrom(this.mFrom);
        this.aek.D(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.s.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (s.this.adw != null && s.this.adw.aOi() != null) {
                    com.baidu.tieba.card.m.Dn(s.this.adw.aOi().getId());
                    com.baidu.tieba.card.m.a(s.this.aek.mTitle, s.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(s.this.aek.adV, s.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aek.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aek.setNeedFrsTabName(z);
    }
}
