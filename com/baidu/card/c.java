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
    private BjhArticleLayout afH;
    private AbsThreadDataSupport afI;
    private View.OnClickListener afJ;

    public c(Context context) {
        super(context);
        this.afJ = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.afD.getView(), c.this.afI);
            }
        };
        this.afH = new BjhArticleLayout(context);
        this.afH.setJumpToPbListener(this.afJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        this.afH.H(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        super.tA();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c.this.afI != null && c.this.afI.bhz() != null) {
                    com.baidu.tieba.card.n.II(c.this.afI.bhz().getId());
                    com.baidu.tieba.card.n.a(c.this.afH.getTitle(), c.this.afI.bhz().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.afH.setSubClickListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.afI instanceof com.baidu.tieba.card.data.f) || (this.afI instanceof bw)) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.f) {
                com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) this.afI;
                fVar.objType = 1;
                ay.a((AbsThreadDataSupport) fVar, view.getContext(), fVar.erH.eAZ ? 2 : 1, false);
                amVar.tW().b(new a.C0097a(1));
            } else if (qVar instanceof bw) {
                bw bwVar = (bw) this.afI;
                bwVar.objType = 1;
                ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                amVar.tW().b(new a.C0097a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afH.onChangeSkinType(tbPageContext, i);
    }
}
