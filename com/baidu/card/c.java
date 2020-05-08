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
    private BjhArticleLayout adc;
    private com.baidu.tbadk.core.data.a ade;
    private View.OnClickListener adf;

    public c(Context context) {
        super(context);
        this.adf = new View.OnClickListener() { // from class: com.baidu.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.acY.getView(), c.this.ade);
            }
        };
        this.adc = new BjhArticleLayout(context);
        this.adc.setJumpToPbListener(this.adf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        this.adc.B(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        super.rk();
        a(1, new a.b() { // from class: com.baidu.card.c.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c.this.ade != null && c.this.ade.aIu() != null) {
                    com.baidu.tieba.card.l.BE(c.this.ade.aIu().getId());
                    com.baidu.tieba.card.l.a(c.this.adc.getTitle(), c.this.ade.aIu().getId(), (int) R.color.cp_cont_a, (int) R.color.cp_cont_d);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
        this.adc.setSubClickListener(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if (((this.ade instanceof com.baidu.tieba.card.data.e) || (this.ade instanceof bj)) && (view.getTag() instanceof af)) {
            af afVar = (af) view.getTag();
            if (mVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.ade;
                eVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.dqE.dtU ? 2 : 1, false);
                afVar.rD().b(new a.C0095a(1));
            } else if (mVar instanceof bj) {
                bj bjVar = (bj) this.ade;
                bjVar.objType = 1;
                au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                afVar.rD().b(new a.C0095a(1));
            }
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adc.onChangeSkinType(tbPageContext, i);
    }
}
