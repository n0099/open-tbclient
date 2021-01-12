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
    private static final int ahh = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean agO;
    private com.baidu.tbadk.core.data.a agr;
    private TextView ahj;
    private OriginalThreadCardView ajg;
    private OriginalThreadCardView.a ajh;
    private View mRootView;
    private TextView mTitle;

    public ap(Context context) {
        super(context);
        this.agO = false;
        this.ajh = new OriginalThreadCardView.a() { // from class: com.baidu.card.ap.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ap.this.agr != null && ap.this.agr.bkV() != null) {
                    if (ap.this.sR() != null) {
                        ap.this.sR().a(ap.this.ajg, ap.this.agr);
                    }
                    String id = ap.this.agr.bkV().getId();
                    com.baidu.tieba.card.m.Ic(id);
                    ap.this.dd(id);
                    ap.this.agm.b(new a.C0089a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.ahj = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ajg = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ajg.setSubClickListener(this.ajh);
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
        if (aVar != null && aVar.bkV() != null) {
            this.agr = aVar;
            ay.a(this.mTitle, aVar.bkV(), this.agO);
            ay.a(this.ahj, this.mTitle, aVar.bkV(), ahh, this.agO);
            this.ajg.b(aVar.bkV().eQQ);
        }
    }

    public void bD(int i) {
        this.ajg.itw = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.m.a(this.ahj, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ajg.setReadState(com.baidu.tieba.card.m.Id(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajg.onChangeSkinType();
    }

    @Override // com.baidu.card.a
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}
