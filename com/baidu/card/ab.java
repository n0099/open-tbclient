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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes3.dex */
public class ab extends b<com.baidu.tbadk.core.data.a> {
    private static final int VU = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private com.baidu.tbadk.core.data.a VJ;
    private TextView VW;
    private OriginalThreadCardView Xv;
    private OriginalThreadCardView.a Xw;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Xw = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.VJ != null && ab.this.VJ.acy() != null) {
                    if (ab.this.qB() != null) {
                        ab.this.qB().a(ab.this.Xv, ab.this.VJ);
                    }
                    String id = ab.this.VJ.acy().getId();
                    com.baidu.tieba.card.n.vx(id);
                    ab.this.cg(id);
                    ab.this.VB.b(new a.C0038a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.VW = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Xv = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Xv.setSubClickListener(this.Xw);
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
        if (aVar != null && aVar.acy() != null) {
            this.VJ = aVar;
            av.a(this.mTitle, aVar.acy());
            av.a(this.VW, this.mTitle, aVar.acy(), VU);
            this.Xv.b(aVar.acy().bLV);
        }
    }

    public void bx(int i) {
        this.Xv.eEQ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.VW, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Xv.setReadState(com.baidu.tieba.card.n.vy(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xv.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
