package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class q extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Fx;
    public MutiImgSingleVerticalLayout Ge;
    private String mFrom;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Ge = new MutiImgSingleVerticalLayout(context);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ge;
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Ge.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        this.Ge.setFrom(this.mFrom);
        this.Ge.z(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        a(1, new a.b() { // from class: com.baidu.card.q.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (q.this.Fx != null && q.this.Fx.agI() != null) {
                    com.baidu.tieba.card.n.uz(q.this.Fx.agI().getId());
                    com.baidu.tieba.card.n.a(q.this.Ge.mTitle, q.this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(q.this.Ge.FK, q.this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Ge.setFromCDN(z);
    }
}
