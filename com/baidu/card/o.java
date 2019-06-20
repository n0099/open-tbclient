package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class o extends b<com.baidu.tbadk.core.data.a> {
    private MultiImgLayout VR;
    private com.baidu.tbadk.core.data.a Vp;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.VR = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VR;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.VR.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vp = aVar;
        this.VR.setFrom(this.mFrom);
        this.VR.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            this.VR.XS.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        a(1, new a.b() { // from class: com.baidu.card.o.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (o.this.Vp != null && o.this.Vp.abv() != null) {
                    com.baidu.tieba.card.n.uR(o.this.Vp.abv().getId());
                    com.baidu.tieba.card.n.a(o.this.VR.mTitle, o.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.VR.VB, o.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.VR != null) {
            this.VR.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.VR != null) {
            this.VR.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.VR.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.VR.setPreloadSizeReadyCallback(bVar);
    }
}
