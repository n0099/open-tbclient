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
public class y extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private MutiImgTextLayout afW;
    private String mFrom;
    private int mSkinType;

    public y(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afW = new MutiImgTextLayout(context);
        this.afW.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afW;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afW.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afW.setFrom(this.mFrom);
        this.afW.F(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.y.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (y.this.aeW != null && y.this.aeW.bce() != null) {
                    com.baidu.tieba.card.m.GY(y.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(y.this.afW.mTitle, y.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(y.this.afW.afz, y.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.afW.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afW.setNeedFrsTabName(z);
    }
}
