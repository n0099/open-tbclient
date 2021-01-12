package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout agq;
    private com.baidu.tbadk.core.data.a agr;
    private View.OnClickListener ags;

    public b(Context context) {
        super(context);
        this.ags = new View.OnClickListener() { // from class: com.baidu.card.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a(b.this.agm.getView(), b.this.agr);
            }
        };
        this.agq = new BjhArticleLayout(context);
        this.agq.setJumpToPbListener(this.ags);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        this.agq.C(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        super.sQ();
        a(1, new a.b() { // from class: com.baidu.card.b.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (b.this.agr != null && b.this.agr.bkV() != null) {
                    com.baidu.tieba.card.m.Ic(b.this.agr.bkV().getId());
                    com.baidu.tieba.card.m.a(b.this.agq.getTitle(), b.this.agr.bkV().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
        this.agq.setSubClickListener(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.n nVar) {
        if (((this.agr instanceof com.baidu.tieba.card.data.e) || (this.agr instanceof bz)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.agr;
                eVar.objType = 1;
                ay.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.eHK.eRs ? 2 : 1, false);
                threadCardViewHolder.tm().b(new a.C0089a(1));
            } else if (nVar instanceof bz) {
                bz bzVar = (bz) this.agr;
                bzVar.objType = 1;
                ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 3, false);
                threadCardViewHolder.tm().b(new a.C0089a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agq.onChangeSkinType(tbPageContext, i);
    }
}
