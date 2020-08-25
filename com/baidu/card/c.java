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
/* loaded from: classes15.dex */
public class c extends b<AbsThreadDataSupport> {
    private BjhArticleLayout aeV;
    private AbsThreadDataSupport aeW;
    private View.OnClickListener aeX;

    public c(Context context) {
        super(context);
        this.aeX = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.aeR.getView(), c.this.aeW);
            }
        };
        this.aeV = new BjhArticleLayout(context);
        this.aeV.setJumpToPbListener(this.aeX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        this.aeV.F(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        super.tv();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c.this.aeW != null && c.this.aeW.bce() != null) {
                    com.baidu.tieba.card.m.GY(c.this.aeW.bce().getId());
                    com.baidu.tieba.card.m.a(c.this.aeV.getTitle(), c.this.aeW.bce().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.aeV.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.aeW instanceof com.baidu.tieba.card.data.f) || (this.aeW instanceof bw)) && (view.getTag() instanceof al)) {
            al alVar = (al) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.f) {
                com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) this.aeW;
                fVar.objType = 1;
                ay.a((AbsThreadDataSupport) fVar, view.getContext(), fVar.dUS.eef ? 2 : 1, false);
                alVar.tR().b(new a.C0095a(1));
            } else if (qVar instanceof bw) {
                bw bwVar = (bw) this.aeW;
                bwVar.objType = 1;
                ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                alVar.tR().b(new a.C0095a(1));
            }
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeV.onChangeSkinType(tbPageContext, i);
    }
}
