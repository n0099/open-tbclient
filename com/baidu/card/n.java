package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class n extends h {
    private ThreadGodReplyLayout agP;
    private com.baidu.tbadk.core.util.ar agQ;
    private com.baidu.tbadk.core.data.a agj;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.agP = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.sO() != null) {
                    n.this.sO().a(view, n.this.agj);
                }
            }
        };
        this.agP.setAfterClickListener(onClickListener);
        this.agP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.agj.bln().getTid(), n.this.agj.bln().bpv().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.agd.tf());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.agd.b(new a.C0089a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.agP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                com.baidu.tieba.card.m.a(n.this.agP.getGodReplyContent(), n.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ar arVar) {
        this.agQ = arVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agP.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.agP.setFromCDN(z);
    }

    public void setForm(String str) {
        this.agP.setFrom(str);
    }

    public boolean sX() {
        return this.agP == null || this.agP.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        PostData bpv = aVar.bln().bpv();
        if (this.agQ != null && bpv != null && bpv.bnQ() != null && bpv.bnQ().getUserId() != null) {
            this.agQ.dR("tid", aVar.bln().tid).dR("post_id", bpv.getId()).dR("uid", bpv.bnQ().getUserId());
            com.baidu.tieba.card.t.csu().e(this.agQ);
        }
        this.agP.setData(aVar.bln());
    }
}
