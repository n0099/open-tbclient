package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class q extends b<com.baidu.tbadk.core.data.a> {
    public MutiImgSingleVerticalLayout VU;
    private com.baidu.tbadk.core.data.a Vp;
    private String mFrom;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.VU = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VU;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.VU.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vp = aVar;
        this.VU.setFrom(this.mFrom);
        this.VU.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        a(1, new a.b() { // from class: com.baidu.card.q.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (q.this.Vp != null && q.this.Vp.abv() != null) {
                    com.baidu.tieba.card.n.uR(q.this.Vp.abv().getId());
                    com.baidu.tieba.card.n.a(q.this.VU.mTitle, q.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(q.this.VU.VB, q.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.VU.setFromCDN(z);
    }
}
