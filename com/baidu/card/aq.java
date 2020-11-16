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
/* loaded from: classes20.dex */
public class aq extends b<com.baidu.tbadk.core.data.a> {
    private static final int agp;
    private com.baidu.tbadk.core.data.a afN;
    private TextView agr;
    private OriginalThreadCardView aim;
    private boolean ain;
    private OriginalThreadCardView.a aio;
    private View mRootView;
    private TextView mTitle;

    static {
        agp = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public aq(Context context) {
        super(context);
        this.ain = false;
        this.aio = new OriginalThreadCardView.a() { // from class: com.baidu.card.aq.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (aq.this.afN != null && aq.this.afN.bjd() != null) {
                    if (aq.this.tB() != null) {
                        aq.this.tB().a(aq.this.aim, aq.this.afN);
                    }
                    String id = aq.this.afN.bjd().getId();
                    com.baidu.tieba.card.n.IA(id);
                    aq.this.dm(id);
                    aq.this.afI.b(new a.C0096a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.agr = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.aim = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.aim.setSubClickListener(this.aio);
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
        if (aVar != null && aVar.bjd() != null) {
            this.afN = aVar;
            az.a(this.mTitle, aVar.bjd(), this.ain);
            az.a(this.agr, this.mTitle, aVar.bjd(), agp, this.ain);
            this.aim.b(aVar.bjd().eEF);
        }
    }

    public void bB(int i) {
        this.aim.iaK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(String str) {
        com.baidu.tieba.card.n.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        com.baidu.tieba.card.n.a(this.agr, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.aim.setReadState(com.baidu.tieba.card.n.IB(str));
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aim.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> abVar) {
        super.setOnCardSubClickListener(abVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }
}
