package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes15.dex */
public class ao extends b<AbsThreadDataSupport> {
    private static final int aeo = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private AbsThreadDataSupport adQ;
    private TextView aeq;
    private OriginalThreadCardView agm;
    private boolean agn;
    private OriginalThreadCardView.a ago;
    private View mRootView;
    private TextView mTitle;

    public ao(Context context) {
        super(context);
        this.agn = false;
        this.ago = new OriginalThreadCardView.a() { // from class: com.baidu.card.ao.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ao.this.adQ != null && ao.this.adQ.aTN() != null) {
                    if (ao.this.rL() != null) {
                        ao.this.rL().a(ao.this.agm, ao.this.adQ);
                    }
                    String id = ao.this.adQ.aTN().getId();
                    com.baidu.tieba.card.m.Ez(id);
                    ao.this.cX(id);
                    ao.this.adL.b(new a.C0096a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.aeq = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.agm = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.agm.setSubClickListener(this.ago);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.aeq, R.dimen.tbds7, R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            this.adQ = absThreadDataSupport;
            ax.a(this.mTitle, absThreadDataSupport.aTN(), this.agn);
            ax.a(this.aeq, this.mTitle, absThreadDataSupport.aTN(), aeo, this.agn);
            this.agm.b(absThreadDataSupport.aTN().dUi);
        }
    }

    public void bu(int i) {
        this.agm.gYV = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aeq, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.agm.setReadState(com.baidu.tieba.card.m.EA(str));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agm.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }
}
