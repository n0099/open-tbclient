package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class z extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private MutiImgTextLayout ags;
    private String mFrom;
    private int mSkinType;

    public z(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ags = new MutiImgTextLayout(context);
        this.ags.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ags;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.ags.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.ags.setFrom(this.mFrom);
        this.ags.G(absThreadDataSupport);
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
            public boolean a(a.C0096a c0096a) {
                if (z.this.afq != null && z.this.afq.bcY() != null) {
                    com.baidu.tieba.card.m.Hw(z.this.afq.bcY().getId());
                    com.baidu.tieba.card.m.a(z.this.ags.mTitle, z.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(z.this.ags.afT, z.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.ags.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ags.setNeedFrsTabName(z);
    }
}
