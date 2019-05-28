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
    private static final int VA = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView VC;
    private com.baidu.tbadk.core.data.a Vq;
    private OriginalThreadCardView Xb;
    private OriginalThreadCardView.a Xc;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Xc = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Vq != null && ab.this.Vq.abv() != null) {
                    if (ab.this.qf() != null) {
                        ab.this.qf().a(ab.this.Xb, ab.this.Vq);
                    }
                    String id = ab.this.Vq.abv().getId();
                    com.baidu.tieba.card.n.uS(id);
                    ab.this.ce(id);
                    ab.this.Vi.b(new a.C0038a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.VC = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Xb = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Xb.setSubClickListener(this.Xc);
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
            this.Vq = aVar;
            au.a(this.mTitle, aVar.abv());
            au.a(this.VC, this.mTitle, aVar.abv(), VA);
            this.Xb.b(aVar.abv().bKP);
        }
    }

    public void bx(int i) {
        this.Xb.ezN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.VC, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Xb.setReadState(com.baidu.tieba.card.n.uT(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xb.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
