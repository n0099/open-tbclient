package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class w extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agj;
    private MultiImgLayout ahp;
    private String mFrom;
    private int mSkinType;

    public w(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ahp = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahp;
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahp.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        this.ahp.setFrom(this.mFrom);
        this.ahp.C(aVar);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.ahp.alc.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.w.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (w.this.agj != null && w.this.agj.bln() != null) {
                    com.baidu.tieba.card.m.IN(w.this.agj.bln().getId());
                    com.baidu.tieba.card.m.a(w.this.ahp.mTitle, w.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    com.baidu.tieba.card.m.a(w.this.ahp.agY, w.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ahp != null) {
            this.ahp.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ahp != null) {
            this.ahp.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.ahp.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ahp.setPreloadSizeReadyCallback(bVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahp.setNeedFrsTabName(z);
    }
}
