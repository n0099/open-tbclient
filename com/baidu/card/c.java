package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout JG;
    private com.baidu.tbadk.core.data.a JH;
    private View.OnClickListener JI;

    public c(Context context) {
        super(context);
        this.JI = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.JC.getView(), c.this.JH);
            }
        };
        this.JG = new BjhArticleLayout(context);
        this.JG.setJumpToPbListener(this.JI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        this.JG.A(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        super.mD();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c.this.JH != null && c.this.JH.axQ() != null) {
                    com.baidu.tieba.card.l.zC(c.this.JH.axQ().getId());
                    com.baidu.tieba.card.l.a(c.this.JG.getTitle(), c.this.JH.axQ().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.JG.setSubClickListener(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if (((this.JH instanceof com.baidu.tieba.card.data.e) || (this.JH instanceof bj)) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            if (mVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.JH;
                eVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.cNb.cQo ? 2 : 1, false);
                afVar.mU().b(new a.C0050a(1));
            } else if (mVar instanceof bj) {
                bj bjVar = (bj) this.JH;
                bjVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                afVar.mU().b(new a.C0050a(1));
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JG.onChangeSkinType(tbPageContext, i);
    }
}
