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
/* loaded from: classes21.dex */
public class n extends i {
    private AbsThreadDataSupport afH;
    private ThreadGodReplyLayout agb;
    private com.baidu.tbadk.core.util.aq agc;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.agb = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tB() != null) {
                    n.this.tB().a(view, n.this.afH);
                }
            }
        };
        this.agb.setAfterClickListener(onClickListener);
        this.agb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.afH.bfG().getTid(), n.this.afH.bfG().bjK().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.afC.tS());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.afC.b(new a.C0097a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                com.baidu.tieba.card.m.a(n.this.agb.getGodReplyContent(), n.this.afH.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.agc = aqVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agb.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.agb.setFromCDN(z);
    }

    public void setForm(String str) {
        this.agb.setFrom(str);
    }

    public boolean tK() {
        return this.agb == null || this.agb.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        PostData bjK = absThreadDataSupport.bfG().bjK();
        if (this.agc != null && bjK != null && bjK.bih() != null && bjK.bih().getUserId() != null) {
            this.agc.dK("tid", absThreadDataSupport.bfG().tid).dK("post_id", bjK.getId()).dK("uid", bjK.bih().getUserId());
            com.baidu.tieba.card.s.ciJ().e(this.agc);
        }
        this.agb.setData(absThreadDataSupport.bfG());
    }
}
