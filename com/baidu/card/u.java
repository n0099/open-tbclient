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
public class u extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private MultiImgLayout aeI;
    private String mFrom;
    private int mSkinType;

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.aeI = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeI;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        this.aeI.setSubClickListener(aaVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.aeI.setFrom(this.mFrom);
        this.aeI.D(absThreadDataSupport);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.aeI.aip.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, new a.b() { // from class: com.baidu.card.u.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (u.this.adQ != null && u.this.adQ.aTN() != null) {
                    com.baidu.tieba.card.m.Ez(u.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(u.this.aeI.mTitle, u.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    com.baidu.tieba.card.m.a(u.this.aeI.aeq, u.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.aeI != null) {
            this.aeI.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.aeI != null) {
            this.aeI.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.aeI.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aeI.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aeI.setNeedFrsTabName(z);
    }
}
