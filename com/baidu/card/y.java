package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class y extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    public MutiImgSingleVerticalLayout agI;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agI = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agI;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        this.agI.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.agI.setFrom(this.mFrom);
        this.agI.H(absThreadDataSupport);
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
            public boolean a(a.C0097a c0097a) {
                if (y.this.afI != null && y.this.afI.bjZ() != null) {
                    com.baidu.tieba.card.n.IZ(y.this.afI.bjZ().getId());
                    com.baidu.tieba.card.n.a(y.this.agI.mTitle, y.this.afI.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(y.this.agI.agm, y.this.afI.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agI.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agI.setNeedFrsTabName(z);
    }
}
