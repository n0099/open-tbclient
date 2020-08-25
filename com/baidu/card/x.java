package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class x extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    public MutiImgSingleVerticalLayout afU;
    private String mFrom;
    private int mSkinType;

    public x(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afU = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afU;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afU.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afU.setFrom(this.mFrom);
        this.afU.F(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.x.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (x.this.aeW != null && x.this.aeW.bce() != null) {
                    com.baidu.tieba.card.m.GY(x.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(x.this.afU.mTitle, x.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(x.this.afU.afz, x.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afU.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afU.setNeedFrsTabName(z);
    }
}
