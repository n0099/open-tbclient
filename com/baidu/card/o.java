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
    private com.baidu.tbadk.core.data.a Xy;
    private MultiImgLayout Ya;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Ya = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ya;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Ya.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        this.Ya.setFrom(this.mFrom);
        this.Ya.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.Ya.ZZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.o.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (o.this.Xy != null && o.this.Xy.WR() != null) {
                    com.baidu.tieba.card.n.tA(o.this.Xy.WR().getId());
                    com.baidu.tieba.card.n.a(o.this.Ya.mTitle, o.this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.Ya.XK, o.this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.Ya != null) {
            this.Ya.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.Ya != null) {
            this.Ya.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.Ya.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Ya.setPreloadSizeReadyCallback(bVar);
    }
}
