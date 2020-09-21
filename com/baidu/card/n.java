package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes20.dex */
public class n extends i {
    private ThreadGodReplyLayout afK;
    private com.baidu.tbadk.core.util.aq afL;
    private AbsThreadDataSupport afq;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.afK = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tB() != null) {
                    n.this.tB().a(view, n.this.afq);
                }
            }
        };
        this.afK.setAfterClickListener(onClickListener);
        this.afK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.afq.bcY().getTid(), n.this.afq.bcY().bhb().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.afl.tS());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.afl.b(new a.C0096a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                com.baidu.tieba.card.m.a(n.this.afK.getGodReplyContent(), n.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.afL = aqVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afK.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.afK.setFromCDN(z);
    }

    public void setForm(String str) {
        this.afK.setFrom(str);
    }

    public boolean tK() {
        return this.afK == null || this.afK.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        PostData bhb = absThreadDataSupport.bcY().bhb();
        if (this.afL != null && bhb != null && bhb.bfy() != null && bhb.bfy().getUserId() != null) {
            this.afL.dF("tid", absThreadDataSupport.bcY().tid).dF("post_id", bhb.getId()).dF("uid", bhb.bfy().getUserId());
            com.baidu.tieba.card.s.cfn().e(this.afL);
        }
        this.afK.setData(absThreadDataSupport.bcY());
    }
}
