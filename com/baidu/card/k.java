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
/* loaded from: classes6.dex */
public class k extends h {
    private com.baidu.tbadk.core.data.a JH;
    private ThreadGodReplyLayout JW;
    private an JX;

    public k(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.JW = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.mE() != null) {
                    k.this.mE().a(view, k.this.JH);
                }
            }
        };
        this.JW.setAfterClickListener(onClickListener);
        this.JW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(k.this.mContext).createNormalCfg(k.this.JH.axQ().getTid(), k.this.JH.axQ().aBx().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(k.this.JC.mQ());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                k.this.JC.b(new a.C0050a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.JW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, new a.b() { // from class: com.baidu.card.k.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                com.baidu.tieba.card.l.a(k.this.JW.getGodReplyContent(), k.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.JX = anVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.JW.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.JW.setFromCDN(z);
    }

    public void setForm(String str) {
        this.JW.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        PostData aBx = aVar.axQ().aBx();
        if (this.JX != null && aBx != null && aBx.azX() != null && aBx.azX().getUserId() != null) {
            this.JX.cp("tid", aVar.axQ().tid).cp("post_id", aBx.getId()).cp("uid", aBx.azX().getUserId());
            com.baidu.tieba.card.r.btA().c(this.JX);
        }
        this.JW.setData(aVar.axQ());
    }
}
