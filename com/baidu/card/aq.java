package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes21.dex */
public class aq extends b<AbsThreadDataSupport> {
    private static final int agk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private AbsThreadDataSupport afI;
    private TextView agm;
    private OriginalThreadCardView aij;
    private boolean aik;
    private OriginalThreadCardView.a ail;
    private View mRootView;
    private TextView mTitle;

    public aq(Context context) {
        super(context);
        this.aik = false;
        this.ail = new OriginalThreadCardView.a() { // from class: com.baidu.card.aq.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aq.this.afI != null && aq.this.afI.bhz() != null) {
                    if (aq.this.tB() != null) {
                        aq.this.tB().a(aq.this.aij, aq.this.afI);
                    }
                    String id = aq.this.afI.bhz().getId();
                    com.baidu.tieba.card.n.II(id);
                    aq.this.dk(id);
                    aq.this.afD.b(new a.C0097a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.agm = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.aij = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.aij.setSubClickListener(this.ail);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agm, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            this.afI = absThreadDataSupport;
            ay.a(this.mTitle, absThreadDataSupport.bhz(), this.aik);
            ay.a(this.agm, this.mTitle, absThreadDataSupport.bhz(), agk, this.aik);
            this.aij.b(absThreadDataSupport.bhz().eAy);
        }
    }

    public void bD(int i) {
        this.aij.hUm = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.agm, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.aij.setReadState(com.baidu.tieba.card.n.IJ(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aij.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<AbsThreadDataSupport> abVar) {
        super.setOnCardSubClickListener(abVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }
}
