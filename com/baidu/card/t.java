package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class t extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private MutiImgMutiPicLayout aeG;
    private String mFrom;
    private int mSkinType;

    public t(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeG = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeG;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeG.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.aeG.setFrom(this.mFrom);
        this.aeG.D(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.t.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (t.this.adQ != null && t.this.adQ.aTN() != null) {
                    com.baidu.tieba.card.m.Ez(t.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(t.this.aeG.mTitle, t.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(t.this.aeG.aeq, t.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aeG.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeG.setNeedFrsTabName(z);
    }
}
