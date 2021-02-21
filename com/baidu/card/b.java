package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends a<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout agi;
    private com.baidu.tbadk.core.data.a agj;
    private View.OnClickListener agk;

    public b(Context context) {
        super(context);
        this.agk = new View.OnClickListener() { // from class: com.baidu.card.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a(b.this.agd.getView(), b.this.agj);
            }
        };
        this.agi = new BjhArticleLayout(context);
        this.agi.setJumpToPbListener(this.agk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        this.agi.C(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        super.sN();
        a(1, new a.b() { // from class: com.baidu.card.b.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (b.this.agj != null && b.this.agj.bln() != null) {
                    com.baidu.tieba.card.m.IN(b.this.agj.bln().getId());
                    com.baidu.tieba.card.m.a(b.this.agi.getTitle(), b.this.agj.bln().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.agi.setSubClickListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.n nVar) {
        if (((this.agj instanceof com.baidu.tieba.card.data.e) || (this.agj instanceof cb)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.agj;
                eVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.eJQ.eTE ? 2 : 1, false);
                threadCardViewHolder.tj().b(new a.C0089a(1));
            } else if (nVar instanceof cb) {
                cb cbVar = (cb) this.agj;
                cbVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 3, false);
                threadCardViewHolder.tj().b(new a.C0089a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agi.onChangeSkinType(tbPageContext, i);
    }
}
