package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout adZ;
    private AbsThreadDataSupport aea;
    private View.OnClickListener aeb;

    public c(Context context) {
        super(context);
        this.aeb = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.adV.getView(), c.this.aea);
            }
        };
        this.adZ = new BjhArticleLayout(context);
        this.adZ.setJumpToPbListener(this.aeb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        this.adZ.D(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        super.rI();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (c.this.aea != null && c.this.aea.aPS() != null) {
                    com.baidu.tieba.card.m.DO(c.this.aea.aPS().getId());
                    com.baidu.tieba.card.m.a(c.this.adZ.getTitle(), c.this.aea.aPS().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.adZ.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.aea instanceof com.baidu.tieba.card.data.e) || (this.aea instanceof bu)) && (view.getTag() instanceof ak)) {
            ak akVar = (ak) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.aea;
                eVar.objType = 1;
                aw.a((AbsThreadDataSupport) eVar, view.getContext(), eVar.dLi.dOy ? 2 : 1, false);
                akVar.se().b(new a.C0098a(1));
            } else if (qVar instanceof bu) {
                bu buVar = (bu) this.aea;
                buVar.objType = 1;
                aw.a((AbsThreadDataSupport) buVar, view.getContext(), 3, false);
                akVar.se().b(new a.C0098a(1));
            }
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adZ.onChangeSkinType(tbPageContext, i);
    }
}
