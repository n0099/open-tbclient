package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class v extends b<com.baidu.tbadk.core.data.a> {
    private MutiImgTextLayout adT;
    private com.baidu.tbadk.core.data.a ada;
    private String mFrom;
    private int mSkinType;

    public v(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adT = new MutiImgTextLayout(context);
        this.adT.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adT;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adT.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        this.adT.setFrom(this.mFrom);
        this.adT.A(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.v.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (v.this.ada != null && v.this.ada.aIw() != null) {
                    com.baidu.tieba.card.l.BB(v.this.ada.aIw().getId());
                    com.baidu.tieba.card.l.a(v.this.adT.mTitle, v.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(v.this.adT.ady, v.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adT.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.adT.setNeedFrsTabName(z);
    }
}
