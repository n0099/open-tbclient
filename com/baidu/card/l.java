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
public class l extends h {
    private AbsThreadDataSupport adQ;
    private ThreadGodReplyLayout aeh;
    private com.baidu.tbadk.core.util.ap aei;

    public l(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.aeh = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.rL() != null) {
                    l.this.rL().a(view, l.this.adQ);
                }
            }
        };
        this.aeh.setAfterClickListener(onClickListener);
        this.aeh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(l.this.mContext).createNormalCfg(l.this.adQ.aTN().getTid(), l.this.adQ.aTN().aXO().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(l.this.adL.sc());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                l.this.adL.b(new a.C0096a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.aeh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rK() {
        a(1, new a.b() { // from class: com.baidu.card.l.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                com.baidu.tieba.card.m.a(l.this.aeh.getGodReplyContent(), l.this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ap apVar) {
        this.aei = apVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeh.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.aeh.setFromCDN(z);
    }

    public void setForm(String str) {
        this.aeh.setFrom(str);
    }

    public boolean rU() {
        return this.aeh == null || this.aeh.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        PostData aXO = absThreadDataSupport.aTN().aXO();
        if (this.aei != null && aXO != null && aXO.aWl() != null && aXO.aWl().getUserId() != null) {
            this.aei.dn("tid", absThreadDataSupport.aTN().tid).dn("post_id", aXO.getId()).dn("uid", aXO.aWl().getUserId());
            com.baidu.tieba.card.s.bRL().e(this.aei);
        }
        this.aeh.setData(absThreadDataSupport.aTN());
    }
}
