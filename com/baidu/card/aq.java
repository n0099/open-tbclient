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
    private static final int agj = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private AbsThreadDataSupport afH;
    private TextView agl;
    private OriginalThreadCardView aii;
    private boolean aij;
    private OriginalThreadCardView.a aik;
    private View mRootView;
    private TextView mTitle;

    public aq(Context context) {
        super(context);
        this.aij = false;
        this.aik = new OriginalThreadCardView.a() { // from class: com.baidu.card.aq.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aq.this.afH != null && aq.this.afH.bfG() != null) {
                    if (aq.this.tB() != null) {
                        aq.this.tB().a(aq.this.aii, aq.this.afH);
                    }
                    String id = aq.this.afH.bfG().getId();
                    com.baidu.tieba.card.m.Ij(id);
                    aq.this.dk(id);
                    aq.this.afC.b(new a.C0097a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.agl = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.aii = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.aii.setSubClickListener(this.aik);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agl, R.dimen.tbds7, R.dimen.tbds10);
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
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            this.afH = absThreadDataSupport;
            ay.a(this.mTitle, absThreadDataSupport.bfG(), this.aij);
            ay.a(this.agl, this.mTitle, absThreadDataSupport.bfG(), agj, this.aij);
            this.aii.b(absThreadDataSupport.bfG().erY);
        }
    }

    public void bD(int i) {
        this.aii.hHP = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.agl, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.aii.setReadState(com.baidu.tieba.card.m.Ik(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aii.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aij = z;
    }
}
