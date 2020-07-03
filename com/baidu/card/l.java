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
/* loaded from: classes8.dex */
public class l extends h {
    private AbsThreadDataSupport aea;
    private ThreadGodReplyLayout aer;
    private com.baidu.tbadk.core.util.ao aes;

    public l(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.aer = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.rJ() != null) {
                    l.this.rJ().a(view, l.this.aea);
                }
            }
        };
        this.aer.setAfterClickListener(onClickListener);
        this.aer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(l.this.mContext).createNormalCfg(l.this.aea.aPS().getTid(), l.this.aea.aPS().aTS().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(l.this.adV.sa());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                l.this.adV.b(new a.C0098a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, new a.b() { // from class: com.baidu.card.l.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                com.baidu.tieba.card.m.a(l.this.aer.getGodReplyContent(), l.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ao aoVar) {
        this.aes = aoVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aer.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.aer.setFromCDN(z);
    }

    public void setForm(String str) {
        this.aer.setFrom(str);
    }

    public boolean rT() {
        return this.aer == null || this.aer.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        PostData aTS = absThreadDataSupport.aPS().aTS();
        if (this.aes != null && aTS != null && aTS.aSp() != null && aTS.aSp().getUserId() != null) {
            this.aes.dk("tid", absThreadDataSupport.aPS().tid).dk("post_id", aTS.getId()).dk("uid", aTS.aSp().getUserId());
            com.baidu.tieba.card.s.bOA().e(this.aes);
        }
        this.aer.setData(absThreadDataSupport.aPS());
    }
}
