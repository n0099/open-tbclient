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
/* loaded from: classes3.dex */
public class o extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a EX;
    private MultiImgLayout FA;
    private String mFrom;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.FA = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.FA;
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.FA.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        this.FA.setFrom(this.mFrom);
        this.FA.z(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.FA.HI.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        a(1, new a.b() { // from class: com.baidu.card.o.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (o.this.EX != null && o.this.EX.agG() != null) {
                    com.baidu.tieba.card.n.uz(o.this.EX.agG().getId());
                    com.baidu.tieba.card.n.a(o.this.FA.mTitle, o.this.EX.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(o.this.FA.Fk, o.this.EX.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.FA != null) {
            this.FA.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.FA != null) {
            this.FA.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.FA.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.FA.setPreloadSizeReadyCallback(bVar);
    }
}
