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
/* loaded from: classes8.dex */
public class u extends b<AbsThreadDataSupport> {
    private MultiImgLayout aeS;
    private AbsThreadDataSupport aea;
    private String mFrom;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeS = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeS;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeS.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.aeS.setFrom(this.mFrom);
        this.aeS.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.aeS.aix.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, new a.b() { // from class: com.baidu.card.u.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (u.this.aea != null && u.this.aea.aPS() != null) {
                    com.baidu.tieba.card.m.DO(u.this.aea.aPS().getId());
                    com.baidu.tieba.card.m.a(u.this.aeS.mTitle, u.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(u.this.aeS.aeA, u.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.aeS != null) {
            this.aeS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.aeS != null) {
            this.aeS.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.aeS.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aeS.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeS.setNeedFrsTabName(z);
    }
}
