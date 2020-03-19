package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class r extends b<com.baidu.tbadk.core.data.a> {
    private MutiImgMutiPicLayout KP;
    private com.baidu.tbadk.core.data.a Kc;
    private String mFrom;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        this.KP = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.KP;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.KP.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.KP.setFrom(this.mFrom);
        this.KP.A(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.r.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (r.this.Kc != null && r.this.Kc.aAj() != null) {
                    com.baidu.tieba.card.l.zV(r.this.Kc.aAj().getId());
                    com.baidu.tieba.card.l.a(r.this.KP.mTitle, r.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(r.this.KP.KA, r.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.KP.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.KP.setNeedFrsTabName(z);
    }
}
