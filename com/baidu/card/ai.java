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
/* loaded from: classes6.dex */
public class ai extends b<com.baidu.tbadk.core.data.a> {
    private static final int Kc = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private com.baidu.tbadk.core.data.a JH;
    private TextView Kf;
    private OriginalThreadCardView LX;
    private OriginalThreadCardView.a LY;
    private View mRootView;
    private TextView mTitle;

    public ai(Context context) {
        super(context);
        this.LY = new OriginalThreadCardView.a() { // from class: com.baidu.card.ai.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ai.this.JH != null && ai.this.JH.axQ() != null) {
                    if (ai.this.mE() != null) {
                        ai.this.mE().a(ai.this.LX, ai.this.JH);
                    }
                    String id = ai.this.JH.axQ().getId();
                    com.baidu.tieba.card.l.zC(id);
                    ai.this.bZ(id);
                    ai.this.JC.b(new a.C0050a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.Kf = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.LX = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.LX.setSubClickListener(this.LY);
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
        if (aVar != null && aVar.axQ() != null) {
            this.JH = aVar;
            au.a(this.mTitle, aVar.axQ());
            au.a(this.Kf, this.mTitle, aVar.axQ(), Kc);
            this.LX.b(aVar.axQ().cPN);
        }
    }

    public void aW(int i) {
        this.LX.fJm = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(String str) {
        com.baidu.tieba.card.l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.Kf, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.LX.setReadState(com.baidu.tieba.card.l.zD(str));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.LX.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> zVar) {
        super.setOnCardSubClickListener(zVar);
    }
}
