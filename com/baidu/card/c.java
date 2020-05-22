package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout adv;
    private AbsThreadDataSupport adw;
    private View.OnClickListener adx;

    public c(Context context) {
        super(context);
        this.adx = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.adr.getView(), c.this.adw);
            }
        };
        this.adv = new BjhArticleLayout(context);
        this.adv.setJumpToPbListener(this.adx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        this.adv.D(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        super.rr();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c.this.adw != null && c.this.adw.aOi() != null) {
                    com.baidu.tieba.card.m.Dn(c.this.adw.aOi().getId());
                    com.baidu.tieba.card.m.a(c.this.adv.getTitle(), c.this.adw.aOi().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.adv.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.o oVar) {
        if (((this.adw instanceof com.baidu.tieba.card.data.e) || (this.adw instanceof bk)) && (view.getTag() instanceof ag)) {
            ag agVar = (ag) view.getTag();
            if (oVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.adw;
                eVar.objType = 1;
                au.a((AbsThreadDataSupport) eVar, view.getContext(), eVar.dEA.dHM ? 2 : 1, false);
                agVar.rM().b(new a.C0097a(1));
            } else if (oVar instanceof bk) {
                bk bkVar = (bk) this.adw;
                bkVar.objType = 1;
                au.a((AbsThreadDataSupport) bkVar, view.getContext(), 3, false);
                agVar.rM().b(new a.C0097a(1));
            }
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adv.onChangeSkinType(tbPageContext, i);
    }
}
