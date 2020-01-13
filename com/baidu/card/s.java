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
/* loaded from: classes6.dex */
public class s extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    private MultiImgLayout Kv;
    private String mFrom;
    private int mSkinType;

    public s(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Kv = new MultiImgLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Kv;
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        this.Kv.setSubClickListener(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.Kv.setFrom(this.mFrom);
        this.Kv.A(aVar);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.Kv.Nx.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.s.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (s.this.JH != null && s.this.JH.axQ() != null) {
                    com.baidu.tieba.card.l.zC(s.this.JH.axQ().getId());
                    com.baidu.tieba.card.l.a(s.this.Kv.mTitle, s.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.l.a(s.this.Kv.Kf, s.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.Kv != null) {
            this.Kv.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.Kv != null) {
            this.Kv.setConstrainImagePool(bVar);
        }
    }

    public void setFromCDN(boolean z) {
        this.Kv.setFromCDN(z);
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Kv.setPreloadSizeReadyCallback(bVar);
    }
}
