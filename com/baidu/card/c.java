package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.card.a.a;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends b<com.baidu.tbadk.core.data.a> {
    private BjhArticleLayout afM;
    private com.baidu.tbadk.core.data.a afN;
    private View.OnClickListener afO;

    public c(Context context) {
        super(context);
        this.afO = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.afI.getView(), c.this.afN);
            }
        };
        this.afM = new BjhArticleLayout(context);
        this.afM.setJumpToPbListener(this.afO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        this.afM.H(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        super.tA();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c.this.afN != null && c.this.afN.bjd() != null) {
                    com.baidu.tieba.card.n.IA(c.this.afN.bjd().getId());
                    com.baidu.tieba.card.n.a(c.this.afM.getTitle(), c.this.afN.bjd().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.afM.setSubClickListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if (((this.afN instanceof com.baidu.tieba.card.data.e) || (this.afN instanceof bx)) && (view.getTag() instanceof am)) {
            am amVar = (am) view.getTag();
            if (qVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.afN;
                eVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.evQ.eFg ? 2 : 1, false);
                amVar.tW().b(new a.C0096a(1));
            } else if (qVar instanceof bx) {
                bx bxVar = (bx) this.afN;
                bxVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 3, false);
                amVar.tW().b(new a.C0096a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afM.onChangeSkinType(tbPageContext, i);
    }
}
