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
/* loaded from: classes5.dex */
public class ai extends b<com.baidu.tbadk.core.data.a> {
    private static final int JX = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private com.baidu.tbadk.core.data.a JB;
    private TextView JZ;
    private OriginalThreadCardView LR;
    private OriginalThreadCardView.a LS;
    private View mRootView;
    private TextView mTitle;

    public ai(Context context) {
        super(context);
        this.LS = new OriginalThreadCardView.a() { // from class: com.baidu.card.ai.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ai.this.JB != null && ai.this.JB.axx() != null) {
                    if (ai.this.mE() != null) {
                        ai.this.mE().a(ai.this.LR, ai.this.JB);
                    }
                    String id = ai.this.JB.axx().getId();
                    com.baidu.tieba.card.l.zs(id);
                    ai.this.bZ(id);
                    ai.this.Jw.b(new a.C0050a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.JZ = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.LR = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.LR.setSubClickListener(this.LS);
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
        if (aVar != null && aVar.axx() != null) {
            this.JB = aVar;
            au.a(this.mTitle, aVar.axx());
            au.a(this.JZ, this.mTitle, aVar.axx(), JX);
            this.LR.b(aVar.axx().cPD);
        }
    }

    public void aW(int i) {
        this.LR.fGc = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(String str) {
        com.baidu.tieba.card.l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.JZ, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.LR.setReadState(com.baidu.tieba.card.l.zt(str));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.LR.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
    }
}
