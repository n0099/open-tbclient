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
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes3.dex */
public class ab extends b<com.baidu.tbadk.core.data.a> {
    private static final int Vz = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView VB;
    private com.baidu.tbadk.core.data.a Vp;
    private OriginalThreadCardView Xa;
    private OriginalThreadCardView.a Xb;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Xb = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Vp != null && ab.this.Vp.abv() != null) {
                    if (ab.this.qf() != null) {
                        ab.this.qf().a(ab.this.Xa, ab.this.Vp);
                    }
                    String id = ab.this.Vp.abv().getId();
                    com.baidu.tieba.card.n.uR(id);
                    ab.this.ce(id);
                    ab.this.Vh.b(new a.C0038a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.VB = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Xa = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Xa.setSubClickListener(this.Xb);
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
        if (aVar != null && aVar.abv() != null) {
            this.Vp = aVar;
            au.a(this.mTitle, aVar.abv());
            au.a(this.VB, this.mTitle, aVar.abv(), Vz);
            this.Xa.b(aVar.abv().bKQ);
        }
    }

    public void bx(int i) {
        this.Xa.ezN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.VB, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Xa.setReadState(com.baidu.tieba.card.n.uS(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xa.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
