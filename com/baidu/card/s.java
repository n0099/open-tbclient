package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class s extends b<com.baidu.tbadk.core.data.a> {
    private MultiImgLayout KR;
    private com.baidu.tbadk.core.data.a Kc;
    private String mFrom;
    private int mSkinType;

    public s(Context context) {
        super(context);
        this.mSkinType = 3;
        this.KR = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.KR;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.KR.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.KR.setFrom(this.mFrom);
        this.KR.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.KR.Oa.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, new a.b() { // from class: com.baidu.card.s.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (s.this.Kc != null && s.this.Kc.aAj() != null) {
                    com.baidu.tieba.card.l.zV(s.this.Kc.aAj().getId());
                    com.baidu.tieba.card.l.a(s.this.KR.mTitle, s.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(s.this.KR.KA, s.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.KR != null) {
            this.KR.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.KR != null) {
            this.KR.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.KR.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.KR.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.KR.setNeedFrsTabName(z);
    }
}
