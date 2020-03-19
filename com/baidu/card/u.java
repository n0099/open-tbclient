package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class u extends b<com.baidu.tbadk.core.data.a> {
    public MutiImgSingleVerticalLayout KU;
    private com.baidu.tbadk.core.data.a Kc;
    private String mFrom;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.KU = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.KU;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.KU.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.KU.setFrom(this.mFrom);
        this.KU.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, new a.b() { // from class: com.baidu.card.u.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (u.this.Kc != null && u.this.Kc.aAj() != null) {
                    com.baidu.tieba.card.l.zV(u.this.Kc.aAj().getId());
                    com.baidu.tieba.card.l.a(u.this.KU.mTitle, u.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(u.this.KU.KA, u.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.KU.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.KU.setNeedFrsTabName(z);
    }
}
