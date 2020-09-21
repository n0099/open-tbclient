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
/* loaded from: classes20.dex */
public class aq extends b<AbsThreadDataSupport> {
    private static final int afR = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView afT;
    private AbsThreadDataSupport afq;
    private OriginalThreadCardView ahQ;
    private boolean ahR;
    private OriginalThreadCardView.a ahS;
    private View mRootView;
    private TextView mTitle;

    public aq(Context context) {
        super(context);
        this.ahR = false;
        this.ahS = new OriginalThreadCardView.a() { // from class: com.baidu.card.aq.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aq.this.afq != null && aq.this.afq.bcY() != null) {
                    if (aq.this.tB() != null) {
                        aq.this.tB().a(aq.this.ahQ, aq.this.afq);
                    }
                    String id = aq.this.afq.bcY().getId();
                    com.baidu.tieba.card.m.Hw(id);
                    aq.this.dk(id);
                    aq.this.afl.b(new a.C0096a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.afT = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ahQ = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ahQ.setSubClickListener(this.ahS);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afT, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            this.afq = absThreadDataSupport;
            ay.a(this.mTitle, absThreadDataSupport.bcY(), this.ahR);
            ay.a(this.afT, this.mTitle, absThreadDataSupport.bcY(), afR, this.ahR);
            this.ahQ.b(absThreadDataSupport.bcY().efS);
        }
    }

    public void bD(int i) {
        this.ahQ.hsV = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.afT, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.ahQ.setReadState(com.baidu.tieba.card.m.Hx(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahQ.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }
}
