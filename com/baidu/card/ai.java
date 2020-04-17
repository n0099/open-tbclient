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
    private static final int adw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private com.baidu.tbadk.core.data.a ada;
    private TextView ady;
    private OriginalThreadCardView afk;
    private boolean afl;
    private OriginalThreadCardView.a afm;
    private View mRootView;
    private TextView mTitle;

    public ai(Context context) {
        super(context);
        this.afl = false;
        this.afm = new OriginalThreadCardView.a() { // from class: com.baidu.card.ai.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ai.this.ada != null && ai.this.ada.aIw() != null) {
                    if (ai.this.rl() != null) {
                        ai.this.rl().a(ai.this.afk, ai.this.ada);
                    }
                    String id = ai.this.ada.aIw().getId();
                    com.baidu.tieba.card.l.BB(id);
                    ai.this.cW(id);
                    ai.this.acV.b(new a.C0074a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.ady = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.afk = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.afk.setSubClickListener(this.afm);
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
        if (aVar != null && aVar.aIw() != null) {
            this.ada = aVar;
            au.a(this.mTitle, aVar.aIw(), this.afl);
            au.a(this.ady, this.mTitle, aVar.aIw(), adw, this.afl);
            this.afk.b(aVar.aIw().dto);
        }
    }

    public void bm(int i) {
        this.afk.grn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str) {
        com.baidu.tieba.card.l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.ady, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.afk.setReadState(com.baidu.tieba.card.l.BC(str));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afk.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}
