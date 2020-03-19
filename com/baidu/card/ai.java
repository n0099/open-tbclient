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
/* loaded from: classes8.dex */
public class ai extends b<com.baidu.tbadk.core.data.a> {
    private static final int Ky = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private OriginalThreadCardView Mv;
    private boolean Mw;
    private OriginalThreadCardView.a Mx;
    private View mRootView;
    private TextView mTitle;

    public ai(Context context) {
        super(context);
        this.Mw = false;
        this.Mx = new OriginalThreadCardView.a() { // from class: com.baidu.card.ai.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ai.this.Kc != null && ai.this.Kc.aAj() != null) {
                    if (ai.this.mT() != null) {
                        ai.this.mT().a(ai.this.Mv, ai.this.Kc);
                    }
                    String id = ai.this.Kc.aAj().getId();
                    com.baidu.tieba.card.l.zV(id);
                    ai.this.cb(id);
                    ai.this.JX.b(new a.C0052a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.KA = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.Mv = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.Mv.setSubClickListener(this.Mx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aAj() != null) {
            this.Kc = aVar;
            au.a(this.mTitle, aVar.aAj(), this.Mw);
            au.a(this.KA, this.mTitle, aVar.aAj(), Ky, this.Mw);
            this.Mv.b(aVar.aAj().cUe);
        }
    }

    public void ba(int i) {
        this.Mv.fMG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str) {
        com.baidu.tieba.card.l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.KA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.Mv.setReadState(com.baidu.tieba.card.l.zW(str));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Mv.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.Mw = z;
    }
}
