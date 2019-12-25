package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes5.dex */
public class k extends h {
    private com.baidu.tbadk.core.data.a JB;
    private ThreadGodReplyLayout JR;
    private an JS;

    public k(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.JR = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.mE() != null) {
                    k.this.mE().a(view, k.this.JB);
                }
            }
        };
        this.JR.setAfterClickListener(onClickListener);
        this.JR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(k.this.mContext).createNormalCfg(k.this.JB.axx().getTid(), k.this.JB.axx().aBe().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(k.this.Jw.mP());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                k.this.Jw.b(new a.C0050a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.k.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                com.baidu.tieba.card.l.a(k.this.JR.getGodReplyContent(), k.this.JB.axx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.JS = anVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JR.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.JR.setFromCDN(z);
    }

    public void setForm(String str) {
        this.JR.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        PostData aBe = aVar.axx().aBe();
        if (this.JS != null && aBe != null && aBe.azE() != null && aBe.azE().getUserId() != null) {
            this.JS.cp("tid", aVar.axx().tid).cp("post_id", aBe.getId()).cp("uid", aBe.azE().getUserId());
            com.baidu.tieba.card.r.bsy().c(this.JS);
        }
        this.JR.setData(aVar.axx());
    }
}
