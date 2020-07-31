package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout adP;
    private AbsThreadDataSupport adQ;
    private View.OnClickListener adR;

    public c(Context context) {
        super(context);
        this.adR = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.adL.getView(), c.this.adQ);
            }
        };
        this.adP = new BjhArticleLayout(context);
        this.adP.setJumpToPbListener(this.adR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        this.adP.D(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        super.rK();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c.this.adQ != null && c.this.adQ.aTN() != null) {
                    com.baidu.tieba.card.m.Ez(c.this.adQ.aTN().getId());
                    com.baidu.tieba.card.m.a(c.this.adP.getTitle(), c.this.adQ.aTN().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.adP.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.adQ instanceof com.baidu.tieba.card.data.e) || (this.adQ instanceof bv)) && (view.getTag() instanceof ak)) {
            ak akVar = (ak) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.adQ;
                eVar.objType = 1;
                ax.a((AbsThreadDataSupport) eVar, view.getContext(), eVar.dLK.dUJ ? 2 : 1, false);
                akVar.sg().b(new a.C0096a(1));
            } else if (qVar instanceof bv) {
                bv bvVar = (bv) this.adQ;
                bvVar.objType = 1;
                ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 3, false);
                akVar.sg().b(new a.C0096a(1));
            }
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adP.onChangeSkinType(tbPageContext, i);
    }
}
