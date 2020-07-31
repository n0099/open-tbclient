package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class x extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private MutiImgTextLayout aeN;
    private String mFrom;
    private int mSkinType;

    public x(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeN = new MutiImgTextLayout(context);
        this.aeN.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeN;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeN.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.aeN.setFrom(this.mFrom);
        this.aeN.D(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.x.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (x.this.adQ != null && x.this.adQ.aTN() != null) {
                    com.baidu.tieba.card.m.Ez(x.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(x.this.aeN.mTitle, x.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(x.this.aeN.aeq, x.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.aeN.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeN.setNeedFrsTabName(z);
    }
}
