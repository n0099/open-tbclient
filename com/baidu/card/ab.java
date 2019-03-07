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
    private static final int XH = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);
    private TextView XJ;
    private com.baidu.tbadk.core.data.a Xx;
    private OriginalThreadCardView Zh;
    private OriginalThreadCardView.a Zi;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Zi = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Xx != null && ab.this.Xx.WR() != null) {
                    if (ab.this.rk() != null) {
                        ab.this.rk().a(ab.this.Zh, ab.this.Xx);
                    }
                    String id = ab.this.Xx.WR().getId();
                    com.baidu.tieba.card.n.tB(id);
                    ab.this.cu(id);
                    ab.this.Xp.b(new a.C0037a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(d.h.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_card_title);
        this.XJ = (TextView) this.mRootView.findViewById(d.g.thread_card_abstract);
        this.Zh = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_view);
        this.Zh.setSubClickListener(this.Zi);
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
        if (aVar != null && aVar.WR() != null) {
            this.Xx = aVar;
            au.a(this.mTitle, aVar.WR());
            au.a(this.XJ, this.mTitle, aVar.WR(), XH);
            this.Zh.b(aVar.WR().bDt);
        }
    }

    public void bB(int i) {
        this.Zh.ekp = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.XJ, str, d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        this.Zh.setReadState(com.baidu.tieba.card.n.tC(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Zh.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
