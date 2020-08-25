package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class v extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private MultiImgLayout afR;
    private String mFrom;
    private int mSkinType;

    public v(Context context) {
        super(context);
        this.mSkinType = 3;
        this.afR = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afR;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.afR.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.afR.setFrom(this.mFrom);
        this.afR.F(absThreadDataSupport);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.afR.ajE.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.v.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (v.this.aeW != null && v.this.aeW.bce() != null) {
                    com.baidu.tieba.card.m.GY(v.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(v.this.afR.mTitle, v.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(v.this.afR.afz, v.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.afR != null) {
            this.afR.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.afR != null) {
            this.afR.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.afR.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.afR.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afR.setNeedFrsTabName(z);
    }
}
