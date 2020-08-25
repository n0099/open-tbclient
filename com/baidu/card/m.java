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
/* loaded from: classes15.dex */
public class m extends h {
    private AbsThreadDataSupport aeW;
    private ThreadGodReplyLayout afq;
    private com.baidu.tbadk.core.util.aq afr;

    public m(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.afq = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tw() != null) {
                    m.this.tw().a(view, m.this.aeW);
                }
            }
        };
        this.afq.setAfterClickListener(onClickListener);
        this.afq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(m.this.mContext).createNormalCfg(m.this.aeW.bce().getTid(), m.this.aeW.bce().bgh().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(m.this.aeR.tN());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                m.this.aeR.b(new a.C0095a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.m.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                com.baidu.tieba.card.m.a(m.this.afq.getGodReplyContent(), m.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.afr = aqVar;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afq.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.afq.setFromCDN(z);
    }

    public void setForm(String str) {
        this.afq.setFrom(str);
    }

    public boolean tF() {
        return this.afq == null || this.afq.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        PostData bgh = absThreadDataSupport.bce().bgh();
        if (this.afr != null && bgh != null && bgh.beE() != null && bgh.beE().getUserId() != null) {
            this.afr.dD("tid", absThreadDataSupport.bce().tid).dD("post_id", bgh.getId()).dD("uid", bgh.beE().getUserId());
            com.baidu.tieba.card.s.cbX().e(this.afr);
        }
        this.afq.setData(absThreadDataSupport.bce());
    }
}
