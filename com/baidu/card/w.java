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
/* loaded from: classes20.dex */
public class w extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private MultiImgLayout agn;
    private String mFrom;
    private int mSkinType;

    public w(Context context) {
        super(context);
        this.mSkinType = 3;
        this.agn = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agn;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.agn.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.agn.setFrom(this.mFrom);
        this.agn.G(absThreadDataSupport);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.agn.ake.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.w.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (w.this.afq != null && w.this.afq.bcY() != null) {
                    com.baidu.tieba.card.m.Hw(w.this.afq.bcY().getId());
                    com.baidu.tieba.card.m.a(w.this.agn.mTitle, w.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(w.this.agn.afT, w.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.agn != null) {
            this.agn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.agn != null) {
            this.agn.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.agn.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.agn.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn.setNeedFrsTabName(z);
    }
}
