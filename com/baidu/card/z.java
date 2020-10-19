package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class z extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private MutiImgTextLayout agJ;
    private String mFrom;
    private int mSkinType;

    public z(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agJ = new MutiImgTextLayout(context);
        this.agJ.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agJ;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.agJ.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        this.agJ.setFrom(this.mFrom);
        this.agJ.H(absThreadDataSupport);
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
        a(1, new a.b() { // from class: com.baidu.card.z.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (z.this.afH != null && z.this.afH.bfG() != null) {
                    com.baidu.tieba.card.m.Ij(z.this.afH.bfG().getId());
                    com.baidu.tieba.card.m.a(z.this.agJ.mTitle, z.this.afH.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(z.this.agJ.agl, z.this.afH.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.agJ.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agJ.setNeedFrsTabName(z);
    }
}
