package com.baidu.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class r extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a VJ;
    private MutiImgTextLayout Wr;
    private String mFrom;
    private int mSkinType;

    public r(Context context) {
        super(context);
        this.mSkinType = 3;
        this.Wr = new MutiImgTextLayout(context);
        this.Wr.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Wr;
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Wr.setSubClickListener(abVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VJ = aVar;
        this.Wr.setFrom(this.mFrom);
        this.Wr.C(aVar);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qA() {
        a(1, new a.b() { // from class: com.baidu.card.r.1
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (r.this.VJ != null && r.this.VJ.acx() != null) {
                    com.baidu.tieba.card.n.vw(r.this.VJ.acx().getId());
                    com.baidu.tieba.card.n.a(r.this.Wr.mTitle, r.this.VJ.acx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    com.baidu.tieba.card.n.a(r.this.Wr.VW, r.this.VJ.acx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    public void setFromCDN(boolean z) {
        this.Wr.setFromCDN(z);
    }
}
