package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout Kb;
    private com.baidu.tbadk.core.data.a Kc;
    private View.OnClickListener Ke;

    public c(Context context) {
        super(context);
        this.Ke = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.JX.getView(), c.this.Kc);
            }
        };
        this.Kb = new BjhArticleLayout(context);
        this.Kb.setJumpToPbListener(this.Ke);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Kb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        this.Kb.A(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        super.mS();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (c.this.Kc != null && c.this.Kc.aAe() != null) {
                    com.baidu.tieba.card.l.zS(c.this.Kc.aAe().getId());
                    com.baidu.tieba.card.l.a(c.this.Kb.getTitle(), c.this.Kc.aAe().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.Kb.setSubClickListener(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if (((this.Kc instanceof com.baidu.tieba.card.data.e) || (this.Kc instanceof bj)) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            if (mVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.Kc;
                eVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.cRe.cUq ? 2 : 1, false);
                afVar.nk().b(new a.C0052a(1));
            } else if (mVar instanceof bj) {
                bj bjVar = (bj) this.Kc;
                bjVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                afVar.nk().b(new a.C0052a(1));
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Kb.onChangeSkinType(tbPageContext, i);
    }
}
