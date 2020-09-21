package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class y extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    public MutiImgSingleVerticalLayout agq;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agq = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agq;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.agq.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.agq.setFrom(this.mFrom);
        this.agq.G(absThreadDataSupport);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.y.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (y.this.afq != null && y.this.afq.bcY() != null) {
                    com.baidu.tieba.card.m.Hw(y.this.afq.bcY().getId());
                    com.baidu.tieba.card.m.a(y.this.agq.mTitle, y.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(y.this.agq.afT, y.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agq.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agq.setNeedFrsTabName(z);
    }
}
