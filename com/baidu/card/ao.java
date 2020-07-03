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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes8.dex */
public class ao extends b<AbsThreadDataSupport> {
    private static final int aey = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView aeA;
    private AbsThreadDataSupport aea;
    private OriginalThreadCardView agv;
    private boolean agw;
    private OriginalThreadCardView.a agx;
    private View mRootView;
    private TextView mTitle;

    public ao(Context context) {
        super(context);
        this.agw = false;
        this.agx = new OriginalThreadCardView.a() { // from class: com.baidu.card.ao.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (ao.this.aea != null && ao.this.aea.aPS() != null) {
                    if (ao.this.rJ() != null) {
                        ao.this.rJ().a(ao.this.agv, ao.this.aea);
                    }
                    String id = ao.this.aea.aPS().getId();
                    com.baidu.tieba.card.m.DO(id);
                    ao.this.cY(id);
                    ao.this.adV.b(new a.C0098a(1));
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_card_title);
        this.aeA = (TextView) this.mRootView.findViewById(R.id.thread_card_abstract);
        this.agv = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_view);
        this.agv.setSubClickListener(this.agx);
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
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            this.aea = absThreadDataSupport;
            aw.a(this.mTitle, absThreadDataSupport.aPS(), this.agw);
            aw.a(this.aeA, this.mTitle, absThreadDataSupport.aPS(), aey, this.agw);
            this.agv.b(absThreadDataSupport.aPS().dNX);
        }
    }

    public void bs(int i) {
        this.agv.gTq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(String str) {
        com.baidu.tieba.card.m.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aeA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.agv.setReadState(com.baidu.tieba.card.m.DP(str));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agv.onChangeSkinType();
    }

    @Override // com.baidu.card.b
    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<AbsThreadDataSupport> aaVar) {
        super.setOnCardSubClickListener(aaVar);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }
}
