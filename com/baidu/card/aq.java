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
/* loaded from: classes21.dex */
public class aq extends b<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    private TextView ahp;
    private OriginalThreadCardView ajl;
    private boolean ajm;
    private OriginalThreadCardView.a ajn;
    private View mRootView;
    private TextView mTitle;

    static {
        ahn = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public aq(Context context) {
        super(context);
        this.ajm = false;
        this.ajn = new OriginalThreadCardView.a() { // from class: com.baidu.card.aq.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aq.this.agJ != null && aq.this.agJ.bmn() != null) {
                    if (aq.this.tE() != null) {
                        aq.this.tE().a(aq.this.ajl, aq.this.agJ);
                    }
                    String id = aq.this.agJ.bmn().getId();
                    com.baidu.tieba.card.n.Jq(id);
                    aq.this.dp(id);
                    aq.this.agE.b(new a.C0097a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.ahp = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.ajl = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.ajl.setSubClickListener(this.ajn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null) {
            this.agJ = aVar;
            az.a(this.mTitle, aVar.bmn(), this.ajm);
            az.a(this.ahp, this.mTitle, aVar.bmn(), ahn, this.ajm);
            this.ajl.b(aVar.bmn().eLH);
        }
    }

    public void bF(int i) {
        this.ajl.ilI = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.n.a(this.ahp, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ajl.setReadState(com.baidu.tieba.card.n.Jr(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajl.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }
}
