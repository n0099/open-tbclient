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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes8.dex */
public class aj extends b<AbsThreadDataSupport> {
    private static final int adT = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView adV;
    private AbsThreadDataSupport adw;
    private OriginalThreadCardView afK;
    private boolean afL;
    private OriginalThreadCardView.a afM;
    private View mRootView;
    private TextView mTitle;

    public aj(Context context) {
        super(context);
        this.afL = false;
        this.afM = new OriginalThreadCardView.a() { // from class: com.baidu.card.aj.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aj.this.adw != null && aj.this.adw.aOi() != null) {
                    if (aj.this.rs() != null) {
                        aj.this.rs().a(aj.this.afK, aj.this.adw);
                    }
                    String id = aj.this.adw.aOi().getId();
                    com.baidu.tieba.card.m.Dn(id);
                    aj.this.cX(id);
                    aj.this.adr.b(new a.C0097a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.adV = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.afK = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.afK.setSubClickListener(this.afM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null) {
            this.adw = absThreadDataSupport;
            au.a(this.mTitle, absThreadDataSupport.aOi(), this.afL);
            au.a(this.adV, this.mTitle, absThreadDataSupport.aOi(), adT, this.afL);
            this.afK.b(absThreadDataSupport.aOi().dHm);
        }
    }

    public void bn(int i) {
        this.afK.gGi = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.adV, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.afK.setReadState(com.baidu.tieba.card.m.Do(str));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afK.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}
