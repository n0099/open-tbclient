package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout JA;
    private com.baidu.tbadk.core.data.a JB;
    private View.OnClickListener JC;

    public c(Context context) {
        super(context);
        this.JC = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.Jw.getView(), c.this.JB);
            }
        };
        this.JA = new BjhArticleLayout(context);
        this.JA.setJumpToPbListener(this.JC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        this.JA.A(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        super.mD();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c.this.JB != null && c.this.JB.axx() != null) {
                    com.baidu.tieba.card.l.zs(c.this.JB.axx().getId());
                    com.baidu.tieba.card.l.a(c.this.JA.getTitle(), c.this.JB.axx().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.JA.setSubClickListener(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if (((this.JB instanceof com.baidu.tieba.card.data.e) || (this.JB instanceof bj)) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            if (mVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.JB;
                eVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.cMR.cQe ? 2 : 1, false);
                afVar.mT().b(new a.C0050a(1));
            } else if (mVar instanceof bj) {
                bj bjVar = (bj) this.JB;
                bjVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                afVar.mT().b(new a.C0050a(1));
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JA.onChangeSkinType(tbPageContext, i);
    }
}
