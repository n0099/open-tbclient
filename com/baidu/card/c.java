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
/* loaded from: classes21.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout afG;
    private AbsThreadDataSupport afH;
    private View.OnClickListener afI;

    public c(Context context) {
        super(context);
        this.afI = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.afC.getView(), c.this.afH);
            }
        };
        this.afG = new BjhArticleLayout(context);
        this.afG.setJumpToPbListener(this.afI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        this.afG.H(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        super.tA();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c.this.afH != null && c.this.afH.bfG() != null) {
                    com.baidu.tieba.card.m.Ij(c.this.afH.bfG().getId());
                    com.baidu.tieba.card.m.a(c.this.afG.getTitle(), c.this.afH.bfG().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.afG.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.afH instanceof com.baidu.tieba.card.data.f) || (this.afH instanceof bw)) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.f) {
                com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) this.afH;
                fVar.objType = 1;
                ay.a((AbsThreadDataSupport) fVar, view.getContext(), fVar.eji.esz ? 2 : 1, false);
                amVar.tW().b(new a.C0097a(1));
            } else if (qVar instanceof bw) {
                bw bwVar = (bw) this.afH;
                bwVar.objType = 1;
                ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                amVar.tW().b(new a.C0097a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afG.onChangeSkinType(tbPageContext, i);
    }
}
