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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes.dex */
public class ap extends a<com.baidu.tbadk.core.data.a> {
    private static final int agW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean agD;
    private TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private OriginalThreadCardView aiU;
    private OriginalThreadCardView.a aiV;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.agD = false;
        this.aiV = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.agj != null && ap.this.agj.bln() != null) {
                    if (ap.this.sO() != null) {
                        ap.this.sO().a(ap.this.aiU, ap.this.agj);
                    }
                    String id = ap.this.agj.bln().getId();
                    com.baidu.tieba.card.m.IN(id);
                    ap.this.dd(id);
                    ap.this.agd.b(new a.C0089a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.agY = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.aiU = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.aiU.setSubClickListener(this.aiV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bln() != null) {
            this.agj = aVar;
            az.a(this.mTitle, aVar.bln(), this.agD);
            az.a(this.agY, this.mTitle, aVar.bln(), agW, this.agD);
            this.aiU.b(aVar.bln().eTc);
        }
    }

    public void bD(int i) {
        this.aiU.izu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.m.a(this.agY, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.aiU.setReadState(com.baidu.tieba.card.m.IO(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aiU.onChangeSkinType();
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}
