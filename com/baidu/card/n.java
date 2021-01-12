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
    private com.baidu.tbadk.core.data.a agr;
    private ThreadGodReplyLayout aha;
    private com.baidu.tbadk.core.util.aq ahb;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.aha = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.sR() != null) {
                    n.this.sR().a(view, n.this.agr);
                }
            }
        };
        this.aha.setAfterClickListener(onClickListener);
        this.aha.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.agr.bkV().getTid(), n.this.agr.bkV().bpd().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.agm.ti());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.agm.b(new a.C0089a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aha;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                com.baidu.tieba.card.m.a(n.this.aha.getGodReplyContent(), n.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.ahb = aqVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aha.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.aha.setFromCDN(z);
    }

    public void setForm(String str) {
        this.aha.setFrom(str);
    }

    public boolean ta() {
        return this.aha == null || this.aha.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        PostData bpd = aVar.bkV().bpd();
        if (this.ahb != null && bpd != null && bpd.bnx() != null && bpd.bnx().getUserId() != null) {
            this.ahb.dW("tid", aVar.bkV().tid).dW("post_id", bpd.getId()).dW("uid", bpd.bnx().getUserId());
            com.baidu.tieba.card.s.crj().e(this.ahb);
        }
        this.aha.setData(aVar.bkV());
    }
}
