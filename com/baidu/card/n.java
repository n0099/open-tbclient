package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends b<com.baidu.tbadk.core.data.a> {
    private MutiImgMutiPicLayout XZ;
    private com.baidu.tbadk.core.data.a Xz;
    private String mFrom;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.XZ = new MutiImgMutiPicLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XZ;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.XZ.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xz = aVar;
        this.XZ.setFrom(this.mFrom);
        this.XZ.C(aVar);
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
                if (n.this.Xz != null && n.this.Xz.WO() != null) {
                    com.baidu.tieba.card.n.tz(n.this.Xz.WO().getId());
                    com.baidu.tieba.card.n.a(n.this.XZ.mTitle, n.this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    com.baidu.tieba.card.n.a(n.this.XZ.XL, n.this.Xz.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.XZ.setFromCDN(z);
    }
}
