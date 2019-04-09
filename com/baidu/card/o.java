package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Xz;
    private MultiImgLayout Yb;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Yb = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Yb;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Yb.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xz = aVar;
        this.Yb.setFrom(this.mFrom);
        this.Yb.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.Yb.aab.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.o.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (o.this.Xz != null && o.this.Xz.WO() != null) {
                    com.baidu.tieba.card.n.tz(o.this.Xz.WO().getId());
                    com.baidu.tieba.card.n.a(o.this.Yb.mTitle, o.this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.Yb.XL, o.this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.Yb != null) {
            this.Yb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.Yb != null) {
            this.Yb.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.Yb.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Yb.setPreloadSizeReadyCallback(bVar);
    }
}
