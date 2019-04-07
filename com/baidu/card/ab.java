package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ab extends b<com.baidu.tbadk.core.data.a> {
    private static final int XI = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);
    private TextView XK;
    private com.baidu.tbadk.core.data.a Xy;
    private OriginalThreadCardView Zi;
    private OriginalThreadCardView.a Zj;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Zj = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Xy != null && ab.this.Xy.WO() != null) {
                    if (ab.this.rk() != null) {
                        ab.this.rk().a(ab.this.Zi, ab.this.Xy);
                    }
                    String id = ab.this.Xy.WO().getId();
                    com.baidu.tieba.card.n.tz(id);
                    ab.this.cu(id);
                    ab.this.Xq.b(new a.C0039a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(d.h.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_card_title);
        this.XK = (TextView) this.mRootView.findViewById(d.g.thread_card_abstract);
        this.Zi = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_view);
        this.Zi.setSubClickListener(this.Zj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.WO() != null) {
            this.Xy = aVar;
            au.a(this.mTitle, aVar.WO());
            au.a(this.XK, this.mTitle, aVar.WO(), XI);
            this.Zi.b(aVar.WO().bDy);
        }
    }

    public void bA(int i) {
        this.Zi.ejX = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.XK, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        this.Zi.setReadState(com.baidu.tieba.card.n.tA(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Zi.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
