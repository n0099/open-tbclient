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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes.dex */
public class ap extends a<com.baidu.tbadk.core.data.a> {
    private static final int ahY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean ahF;
    private com.baidu.tbadk.core.data.a ahi;
    private TextView aia;
    private OriginalThreadCardView ajX;
    private OriginalThreadCardView.a ajY;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.ahF = false;
        this.ajY = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.ahi != null && ap.this.ahi.boO() != null) {
                    if (ap.this.tc() != null) {
                        ap.this.tc().a(ap.this.ajX, ap.this.ahi);
                    }
                    String id = ap.this.ahi.boO().getId();
                    com.baidu.tieba.card.m.Jo(id);
                    ap.this.di(id);
                    ap.this.ahd.b(new a.C0090a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.aia = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ajX = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ajX.setSubClickListener(this.ajY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.boO() != null) {
            this.ahi = aVar;
            ay.a(this.mTitle, aVar.boO(), this.ahF);
            ay.a(this.aia, this.mTitle, aVar.boO(), ahY, this.ahF);
            this.ajX.b(aVar.boO().eVB);
        }
    }

    public void bF(int i) {
        this.ajX.iyd = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.m.a(this.aia, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ajX.setReadState(com.baidu.tieba.card.m.Jp(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajX.onChangeSkinType();
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}
