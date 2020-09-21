package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout afp;
    private AbsThreadDataSupport afq;
    private View.OnClickListener afr;

    public c(Context context) {
        super(context);
        this.afr = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.afl.getView(), c.this.afq);
            }
        };
        this.afp = new BjhArticleLayout(context);
        this.afp.setJumpToPbListener(this.afr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        this.afp.G(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        super.tA();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c.this.afq != null && c.this.afq.bcY() != null) {
                    com.baidu.tieba.card.m.Hw(c.this.afq.bcY().getId());
                    com.baidu.tieba.card.m.a(c.this.afp.getTitle(), c.this.afq.bcY().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.afp.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.afq instanceof com.baidu.tieba.card.data.f) || (this.afq instanceof bw)) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.f) {
                com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) this.afq;
                fVar.objType = 1;
                ay.a((AbsThreadDataSupport) fVar, view.getContext(), fVar.dXg.egt ? 2 : 1, false);
                amVar.tW().b(new a.C0096a(1));
            } else if (qVar instanceof bw) {
                bw bwVar = (bw) this.afq;
                bwVar.objType = 1;
                ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                amVar.tW().b(new a.C0096a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afp.onChangeSkinType(tbPageContext, i);
    }
}
