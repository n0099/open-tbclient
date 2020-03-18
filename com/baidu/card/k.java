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
    private com.baidu.tbadk.core.data.a Kc;
    private ThreadGodReplyLayout Ks;
    private an Kt;

    public k(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.Ks = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.mT() != null) {
                    k.this.mT().a(view, k.this.Kc);
                }
            }
        };
        this.Ks.setAfterClickListener(onClickListener);
        this.Ks.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(k.this.mContext).createNormalCfg(k.this.Kc.aAj().getTid(), k.this.Kc.aAj().aDQ().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(k.this.JX.ng());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                k.this.JX.b(new a.C0052a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Ks;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, new a.b() { // from class: com.baidu.card.k.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                com.baidu.tieba.card.l.a(k.this.Ks.getGodReplyContent(), k.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.Kt = anVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Ks.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.Ks.setFromCDN(z);
    }

    public void setForm(String str) {
        this.Ks.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        PostData aDQ = aVar.aAj().aDQ();
        if (this.Kt != null && aDQ != null && aDQ.aCr() != null && aDQ.aCr().getUserId() != null) {
            this.Kt.cx("tid", aVar.aAj().tid).cx("post_id", aDQ.getId()).cx("uid", aDQ.aCr().getUserId());
            com.baidu.tieba.card.r.bvm().e(this.Kt);
        }
        this.Ks.setData(aVar.aAj());
    }
}
