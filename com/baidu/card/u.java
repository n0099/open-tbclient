package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class u extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private MutiImgMutiPicLayout afP;
    private String mFrom;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afP = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afP;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afP.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afP.setFrom(this.mFrom);
        this.afP.F(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.u.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (u.this.aeW != null && u.this.aeW.bce() != null) {
                    com.baidu.tieba.card.m.GY(u.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(u.this.afP.mTitle, u.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(u.this.afP.afz, u.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afP.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afP.setNeedFrsTabName(z);
    }
}
