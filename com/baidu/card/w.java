package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends b<AbsThreadDataSupport> {
    public MutiImgSingleVerticalLayout aeV;
    private AbsThreadDataSupport aea;
    private String mFrom;
    private int mSkinType;

    public w(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeV = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeV;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeV.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aeV.setFrom(this.mFrom);
        this.aeV.D(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.w.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (w.this.aea != null && w.this.aea.aPS() != null) {
                    com.baidu.tieba.card.m.DO(w.this.aea.aPS().getId());
                    com.baidu.tieba.card.m.a(w.this.aeV.mTitle, w.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(w.this.aeV.aeA, w.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aeV.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeV.setNeedFrsTabName(z);
    }
}
