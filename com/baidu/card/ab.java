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
    private static final int FI = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView FK;
    private com.baidu.tbadk.core.data.a Fx;
    private OriginalThreadCardView Hn;
    private OriginalThreadCardView.a Ho;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Ho = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.Fx != null && ab.this.Fx.agI() != null) {
                    if (ab.this.lH() != null) {
                        ab.this.lH().a(ab.this.Hn, ab.this.Fx);
                    }
                    String id = ab.this.Fx.agI().getId();
                    com.baidu.tieba.card.n.uz(id);
                    ab.this.bt(id);
                    ab.this.Fp.b(new a.C0044a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.FK = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Hn = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Hn.setSubClickListener(this.Ho);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.agI() != null) {
            this.Fx = aVar;
            au.a(this.mTitle, aVar.agI());
            au.a(this.FK, this.mTitle, aVar.agI(), FI);
            this.Hn.b(aVar.agI().cec);
        }
    }

    public void aM(int i) {
        this.Hn.ePg = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.FK, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Hn.setReadState(com.baidu.tieba.card.n.uA(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Hn.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void a(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.a(abVar);
    }
}
