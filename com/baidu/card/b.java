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
    private BjhArticleLayout ahA;
    private com.baidu.tbadk.core.data.a ahB;
    private View.OnClickListener ahC;

    public b(Context context) {
        super(context);
        this.ahC = new View.OnClickListener() { // from class: com.baidu.card.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a(b.this.ahw.getView(), b.this.ahB);
            }
        };
        this.ahA = new BjhArticleLayout(context);
        this.ahA.setJumpToPbListener(this.ahC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        this.ahA.E(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        super.sN();
        a(1, new a.b() { // from class: com.baidu.card.b.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (b.this.ahB != null && b.this.ahB.blp() != null) {
                    com.baidu.tieba.card.m.IW(b.this.ahB.blp().getId());
                    com.baidu.tieba.card.m.a(b.this.ahA.getTitle(), b.this.ahB.blp().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
        });
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
        this.ahA.setSubClickListener(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.n nVar) {
        if (((this.ahB instanceof com.baidu.tieba.card.data.e) || (this.ahB instanceof cb)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof com.baidu.tieba.card.data.e) {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) this.ahB;
                eVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), eVar.eLr.eVf ? 2 : 1, false);
                threadCardViewHolder.tj().b(new a.C0095a(1));
            } else if (nVar instanceof cb) {
                cb cbVar = (cb) this.ahB;
                cbVar.objType = 1;
                az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 3, false);
                threadCardViewHolder.tj().b(new a.C0095a(1));
            }
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahA.onChangeSkinType(tbPageContext, i);
    }
}
