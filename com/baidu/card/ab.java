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
    private static final int XJ = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);
    private TextView XL;
    private com.baidu.tbadk.core.data.a Xz;
    private OriginalThreadCardView Zj;
    private OriginalThreadCardView.a Zk;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Zk = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Xz != null && ab.this.Xz.WO() != null) {
                    if (ab.this.rk() != null) {
                        ab.this.rk().a(ab.this.Zj, ab.this.Xz);
                    }
                    String id = ab.this.Xz.WO().getId();
                    com.baidu.tieba.card.n.tz(id);
                    ab.this.cu(id);
                    ab.this.Xr.b(new a.C0039a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(d.h.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_card_title);
        this.XL = (TextView) this.mRootView.findViewById(d.g.thread_card_abstract);
        this.Zj = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_view);
        this.Zj.setSubClickListener(this.Zk);
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
            this.Xz = aVar;
            au.a(this.mTitle, aVar.WO());
            au.a(this.XL, this.mTitle, aVar.WO(), XJ);
            this.Zj.b(aVar.WO().bDz);
        }
    }

    public void bA(int i) {
        this.Zj.ejY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.XL, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        this.Zj.setReadState(com.baidu.tieba.card.n.tA(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Zj.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
