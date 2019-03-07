package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Xx;
    public MutiImgSingleVerticalLayout Yc;
    private String mFrom;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Yc = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Yc;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Yc.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        this.Yc.setFrom(this.mFrom);
        this.Yc.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.q.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0037a c0037a) {
                if (q.this.Xx != null && q.this.Xx.WR() != null) {
                    com.baidu.tieba.card.n.tB(q.this.Xx.WR().getId());
                    com.baidu.tieba.card.n.a(q.this.Yc.mTitle, q.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                    com.baidu.tieba.card.n.a(q.this.Yc.XJ, q.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Yc.setFromCDN(z);
    }
}
