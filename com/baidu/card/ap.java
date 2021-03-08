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
    private static final int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private com.baidu.tbadk.core.data.a ahB;
    private boolean ahV;
    private TextView air;
    private OriginalThreadCardView akm;
    private OriginalThreadCardView.a akn;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.ahV = false;
        this.akn = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.ahB != null && ap.this.ahB.blp() != null) {
                    if (ap.this.sO() != null) {
                        ap.this.sO().a(ap.this.akm, ap.this.ahB);
                    }
                    String id = ap.this.ahB.blp().getId();
                    com.baidu.tieba.card.m.IW(id);
                    ap.this.dh(id);
                    ap.this.ahw.b(new a.C0095a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.air = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.akm = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.akm.setSubClickListener(this.akn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null) {
            this.ahB = aVar;
            az.a(this.mTitle, aVar.blp(), this.ahV);
            az.a(this.air, this.mTitle, aVar.blp(), aip, this.ahV);
            this.akm.b(aVar.blp().eUD);
        }
    }

    public void bE(int i) {
        this.akm.iBd = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.m.a(this.air, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.akm.setReadState(com.baidu.tieba.card.m.IX(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akm.onChangeSkinType();
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}
