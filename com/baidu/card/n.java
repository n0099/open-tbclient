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
    private AbsThreadDataSupport afI;
    private ThreadGodReplyLayout agc;
    private com.baidu.tbadk.core.util.aq agd;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.agc = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tB() != null) {
                    n.this.tB().a(view, n.this.afI);
                }
            }
        };
        this.agc.setAfterClickListener(onClickListener);
        this.agc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.afI.bjZ().getTid(), n.this.afI.bjZ().bod().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.afD.tS());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.afD.b(new a.C0097a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                com.baidu.tieba.card.n.a(n.this.agc.getGodReplyContent(), n.this.afI.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.agd = aqVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agc.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.agc.setFromCDN(z);
    }

    public void setForm(String str) {
        this.agc.setFrom(str);
    }

    public boolean tK() {
        return this.agc == null || this.agc.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        PostData bod = absThreadDataSupport.bjZ().bod();
        if (this.agd != null && bod != null && bod.bmA() != null && bod.bmA().getUserId() != null) {
            this.agd.dR("tid", absThreadDataSupport.bjZ().tid).dR("post_id", bod.getId()).dR("uid", bod.bmA().getUserId());
            com.baidu.tieba.card.t.cor().e(this.agd);
        }
        this.agc.setData(absThreadDataSupport.bjZ());
    }
}
