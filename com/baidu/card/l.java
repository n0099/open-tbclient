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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes8.dex */
public class l extends h {
    private ThreadGodReplyLayout adN;
    private an adO;
    private AbsThreadDataSupport adw;

    public l(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.adN = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.rs() != null) {
                    l.this.rs().a(view, l.this.adw);
                }
            }
        };
        this.adN.setAfterClickListener(onClickListener);
        this.adN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(l.this.mContext).createNormalCfg(l.this.adw.aOi().getTid(), l.this.adw.aOi().aSb().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(l.this.adr.rI());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                l.this.adr.b(new a.C0097a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        a(1, new a.b() { // from class: com.baidu.card.l.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                com.baidu.tieba.card.m.a(l.this.adN.getGodReplyContent(), l.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.adO = anVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adN.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.adN.setFromCDN(z);
    }

    public void setForm(String str) {
        this.adN.setFrom(str);
    }

    public boolean rC() {
        return this.adN == null || this.adN.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        PostData aSb = absThreadDataSupport.aOi().aSb();
        if (this.adO != null && aSb != null && aSb.aQx() != null && aSb.aQx().getUserId() != null) {
            this.adO.dh("tid", absThreadDataSupport.aOi().tid).dh("post_id", aSb.getId()).dh("uid", aSb.aQx().getUserId());
            com.baidu.tieba.card.s.bLq().e(this.adO);
        }
        this.adN.setData(absThreadDataSupport.aOi());
    }
}
