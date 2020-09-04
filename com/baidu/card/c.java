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
    private BjhArticleLayout aeX;
    private AbsThreadDataSupport aeY;
    private View.OnClickListener aeZ;

    public c(Context context) {
        super(context);
        this.aeZ = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.aeT.getView(), c.this.aeY);
            }
        };
        this.aeX = new BjhArticleLayout(context);
        this.aeX.setJumpToPbListener(this.aeZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        this.aeX.F(absThreadDataSupport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        super.tv();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c.this.aeY != null && c.this.aeY.bce() != null) {
                    com.baidu.tieba.card.m.GZ(c.this.aeY.bce().getId());
                    com.baidu.tieba.card.m.a(c.this.aeX.getTitle(), c.this.aeY.bce().getId(), R.color.cp_cont_a, R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.aeX.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.aeY instanceof com.baidu.tieba.card.data.f) || (this.aeY instanceof bw)) && (view.getTag() instanceof al)) {
            al alVar = (al) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.f) {
                com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) this.aeY;
                fVar.objType = 1;
                ay.a((AbsThreadDataSupport) fVar, view.getContext(), fVar.dUW.eej ? 2 : 1, false);
                alVar.tR().b(new a.C0095a(1));
            } else if (qVar instanceof bw) {
                bw bwVar = (bw) this.aeY;
                bwVar.objType = 1;
                ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                alVar.tR().b(new a.C0095a(1));
            }
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeX.onChangeSkinType(tbPageContext, i);
    }
}
