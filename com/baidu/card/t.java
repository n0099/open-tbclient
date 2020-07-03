package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class t extends b<AbsThreadDataSupport> {
    private MutiImgMutiPicLayout aeQ;
    private AbsThreadDataSupport aea;
    private String mFrom;
    private int mSkinType;

    public t(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeQ = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeQ;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeQ.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aeQ.setFrom(this.mFrom);
        this.aeQ.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, new a.b() { // from class: com.baidu.card.t.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (t.this.aea != null && t.this.aea.aPS() != null) {
                    com.baidu.tieba.card.m.DO(t.this.aea.aPS().getId());
                    com.baidu.tieba.card.m.a(t.this.aeQ.mTitle, t.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(t.this.aeQ.aeA, t.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aeQ.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeQ.setNeedFrsTabName(z);
    }
}
