package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout ahh;
    private com.baidu.tbadk.core.data.a ahi;
    private View.OnClickListener ahj;

    public b(Context context) {
        super(context);
        this.ahj = new View.OnClickListener() { // from class: com.baidu.card.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a(b.this.ahd.getView(), b.this.ahi);
            }
        };
        this.ahh = new BjhArticleLayout(context);
        this.ahh.setJumpToPbListener(this.ahj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        this.ahh.D(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        super.tb();
        a(1, new a.b() { // from class: com.baidu.card.b.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (b.this.ahi != null && b.this.ahi.boO() != null) {
                    com.baidu.tieba.card.m.Jo(b.this.ahi.boO().getId());
                    com.baidu.tieba.card.m.a(b.this.ahh.getTitle(), b.this.ahi.boO().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.ahh.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.n nVar) {
        if (((this.ahi instanceof com.baidu.tieba.card.data.e) || (this.ahi instanceof bz)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.ahi;
                eVar.objType = 1;
                ay.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.eMv.eWd ? 2 : 1, false);
                threadCardViewHolder.ty().b(new a.C0090a(1));
            } else if (nVar instanceof bz) {
                bz bzVar = (bz) this.ahi;
                bzVar.objType = 1;
                ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 3, false);
                threadCardViewHolder.ty().b(new a.C0090a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahh.onChangeSkinType(tbPageContext, i);
    }
}
