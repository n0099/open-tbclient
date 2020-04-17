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
/* loaded from: classes8.dex */
public class k extends h {
    private com.baidu.tbadk.core.data.a ada;
    private ThreadGodReplyLayout adq;
    private an adr;

    public k(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.adq = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.rl() != null) {
                    k.this.rl().a(view, k.this.ada);
                }
            }
        };
        this.adq.setAfterClickListener(onClickListener);
        this.adq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(k.this.mContext).createNormalCfg(k.this.ada.aIw().getTid(), k.this.ada.aIw().aMe().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(k.this.acV.rz());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                k.this.acV.b(new a.C0074a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.k.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                com.baidu.tieba.card.l.a(k.this.adq.getGodReplyContent(), k.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.adr = anVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adq.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.adq.setFromCDN(z);
    }

    public void setForm(String str) {
        this.adq.setFrom(str);
    }

    public boolean rt() {
        return this.adq == null || this.adq.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        PostData aMe = aVar.aIw().aMe();
        if (this.adr != null && aMe != null && aMe.aKE() != null && aMe.aKE().getUserId() != null) {
            this.adr.cI("tid", aVar.aIw().tid).cI("post_id", aMe.getId()).cI("uid", aMe.aKE().getUserId());
            com.baidu.tieba.card.r.bEY().e(this.adr);
        }
        this.adq.setData(aVar.aIw());
    }
}
