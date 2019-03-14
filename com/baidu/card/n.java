package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends b<com.baidu.tbadk.core.data.a> {
    private MutiImgMutiPicLayout XY;
    private com.baidu.tbadk.core.data.a Xy;
    private String mFrom;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.XY = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XY;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.XY.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        this.XY.setFrom(this.mFrom);
        this.XY.C(aVar);
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
        a(1, new a.b() { // from class: com.baidu.card.n.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                if (n.this.Xy != null && n.this.Xy.WR() != null) {
                    com.baidu.tieba.card.n.tA(n.this.Xy.WR().getId());
                    com.baidu.tieba.card.n.a(n.this.XY.mTitle, n.this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    com.baidu.tieba.card.n.a(n.this.XY.XK, n.this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.XY.setFromCDN(z);
    }
}
