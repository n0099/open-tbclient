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
    private static final int adz = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private OriginalThreadCardView afn;
    private boolean afo;
    private OriginalThreadCardView.a afp;
    private View mRootView;
    private TextView mTitle;

    public ai(Context context) {
        super(context);
        this.afo = false;
        this.afp = new OriginalThreadCardView.a() { // from class: com.baidu.card.ai.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ai.this.ade != null && ai.this.ade.aIu() != null) {
                    if (ai.this.rl() != null) {
                        ai.this.rl().a(ai.this.afn, ai.this.ade);
                    }
                    String id = ai.this.ade.aIu().getId();
                    com.baidu.tieba.card.l.BE(id);
                    ai.this.cW(id);
                    ai.this.acY.b(new a.C0095a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.adB = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.afn = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.afn.setSubClickListener(this.afp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aIu() != null) {
            this.ade = aVar;
            au.a(this.mTitle, aVar.aIu(), this.afo);
            au.a(this.adB, this.mTitle, aVar.aIu(), adz, this.afo);
            this.afn.b(aVar.aIu().dtt);
        }
    }

    public void bm(int i) {
        this.afn.grt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str) {
        com.baidu.tieba.card.l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.adB, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.afn.setReadState(com.baidu.tieba.card.l.BF(str));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afn.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }
}
