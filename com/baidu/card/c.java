package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout acZ;
    private com.baidu.tbadk.core.data.a ada;
    private View.OnClickListener adb;

    public c(Context context) {
        super(context);
        this.adb = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.acV.getView(), c.this.ada);
            }
        };
        this.acZ = new BjhArticleLayout(context);
        this.acZ.setJumpToPbListener(this.adb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.acZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        this.acZ.A(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        super.rk();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (c.this.ada != null && c.this.ada.aIw() != null) {
                    com.baidu.tieba.card.l.BB(c.this.ada.aIw().getId());
                    com.baidu.tieba.card.l.a(c.this.acZ.getTitle(), c.this.ada.aIw().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.acZ.setSubClickListener(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if (((this.ada instanceof com.baidu.tieba.card.data.e) || (this.ada instanceof bj)) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            if (mVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.ada;
                eVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.dqA.dtQ ? 2 : 1, false);
                afVar.rD().b(new a.C0074a(1));
            } else if (mVar instanceof bj) {
                bj bjVar = (bj) this.ada;
                bjVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                afVar.rD().b(new a.C0074a(1));
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.acZ.onChangeSkinType(tbPageContext, i);
    }
}
