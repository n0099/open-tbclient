package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout agI;
    private com.baidu.tbadk.core.data.a agJ;
    private View.OnClickListener agK;

    public c(Context context) {
        super(context);
        this.agK = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.agE.getView(), c.this.agJ);
            }
        };
        this.agI = new BjhArticleLayout(context);
        this.agI.setJumpToPbListener(this.agK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        this.agI.H(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        super.tD();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c.this.agJ != null && c.this.agJ.bmn() != null) {
                    com.baidu.tieba.card.n.Jq(c.this.agJ.bmn().getId());
                    com.baidu.tieba.card.n.a(c.this.agI.getTitle(), c.this.agJ.bmn().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.agI.setSubClickListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.agJ instanceof com.baidu.tieba.card.data.e) || (this.agJ instanceof by)) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.agJ;
                eVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.eCR.eMi ? 2 : 1, false);
                amVar.tZ().b(new a.C0097a(1));
            } else if (qVar instanceof by) {
                by byVar = (by) this.agJ;
                byVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 3, false);
                amVar.tZ().b(new a.C0097a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agI.onChangeSkinType(tbPageContext, i);
    }
}
