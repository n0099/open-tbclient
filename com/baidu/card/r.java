package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class r extends b<com.baidu.tbadk.core.data.a> {
    private MutiImgMutiPicLayout adP;
    private com.baidu.tbadk.core.data.a ade;
    private String mFrom;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adP = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adP;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adP.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.adP.setFrom(this.mFrom);
        this.adP.B(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.r.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (r.this.ade != null && r.this.ade.aIu() != null) {
                    com.baidu.tieba.card.l.BE(r.this.ade.aIu().getId());
                    com.baidu.tieba.card.l.a(r.this.adP.mTitle, r.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(r.this.adP.adB, r.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adP.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.adP.setNeedFrsTabName(z);
    }
}
