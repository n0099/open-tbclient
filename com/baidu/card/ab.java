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
    private static final int VT = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private com.baidu.tbadk.core.data.a VI;
    private TextView VV;
    private OriginalThreadCardView Xu;
    private OriginalThreadCardView.a Xv;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        super(context);
        this.Xv = new OriginalThreadCardView.a() { // from class: com.baidu.card.ab.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ab.this.VI != null && ab.this.VI.acC() != null) {
                    if (ab.this.qC() != null) {
                        ab.this.qC().a(ab.this.Xu, ab.this.VI);
                    }
                    String id = ab.this.VI.acC().getId();
                    com.baidu.tieba.card.n.vW(id);
                    ab.this.cg(id);
                    ab.this.VA.b(new a.C0038a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.VV = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Xu = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Xu.setSubClickListener(this.Xv);
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
        if (aVar != null && aVar.acC() != null) {
            this.VI = aVar;
            au.a(this.mTitle, aVar.acC());
            au.a(this.VV, this.mTitle, aVar.acC(), VT);
            this.Xu.b(aVar.acC().bMt);
        }
    }

    public void bx(int i) {
        this.Xu.eGz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.VV, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Xu.setReadState(com.baidu.tieba.card.n.vX(str));
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Xu.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void b(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.b(abVar);
    }
}
