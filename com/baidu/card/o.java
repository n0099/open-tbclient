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
    private MultiImgLayout XZ;
    private com.baidu.tbadk.core.data.a Xx;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.XZ = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XZ;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.XZ.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        this.XZ.setFrom(this.mFrom);
        this.XZ.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.XZ.ZY.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.o.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0037a c0037a) {
                if (o.this.Xx != null && o.this.Xx.WR() != null) {
                    com.baidu.tieba.card.n.tC(o.this.Xx.WR().getId());
                    com.baidu.tieba.card.n.a(o.this.XZ.mTitle, o.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.XZ.XJ, o.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.XZ != null) {
            this.XZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.XZ != null) {
            this.XZ.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.XZ.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.XZ.setPreloadSizeReadyCallback(bVar);
    }
}
