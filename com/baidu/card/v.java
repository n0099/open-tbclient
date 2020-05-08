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
    private MutiImgTextLayout adW;
    private com.baidu.tbadk.core.data.a ade;
    private String mFrom;
    private int mSkinType;

    public v(Context context) {
        super(context);
        this.mSkinType = 3;
        this.adW = new MutiImgTextLayout(context);
        this.adW.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adW;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.adW.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.adW.setFrom(this.mFrom);
        this.adW.B(aVar);
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
            public boolean a(a.C0095a c0095a) {
                if (v.this.ade != null && v.this.ade.aIu() != null) {
                    com.baidu.tieba.card.l.BE(v.this.ade.aIu().getId());
                    com.baidu.tieba.card.l.a(v.this.adW.mTitle, v.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(v.this.adW.adB, v.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.adW.setFromCDN(z);
    }

    public void setNeedFrsTabName(boolean z) {
        this.adW.setNeedFrsTabName(z);
    }
}
