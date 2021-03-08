package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class n extends h {
    private com.baidu.tbadk.core.data.a ahB;
    private ThreadGodReplyLayout aii;
    private com.baidu.tbadk.core.util.ar aij;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.aii = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.sO() != null) {
                    n.this.sO().a(view, n.this.ahB);
                }
            }
        };
        this.aii.setAfterClickListener(onClickListener);
        this.aii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.ahB.blp().getTid(), n.this.ahB.blp().bpx().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.ahw.tf());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.ahw.b(new a.C0095a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.aii;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                com.baidu.tieba.card.m.a(n.this.aii.getGodReplyContent(), n.this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ar arVar) {
        this.aij = arVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aii.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.aii.setFromCDN(z);
    }

    public void setForm(String str) {
        this.aii.setFrom(str);
    }

    public boolean sX() {
        return this.aii == null || this.aii.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        this.ahB = aVar;
        PostData bpx = aVar.blp().bpx();
        if (this.aij != null && bpx != null && bpx.bnS() != null && bpx.bnS().getUserId() != null) {
            this.aij.dR("tid", aVar.blp().tid).dR("post_id", bpx.getId()).dR("uid", bpx.bnS().getUserId());
            com.baidu.tieba.card.t.csH().e(this.aij);
        }
        this.aii.setData(aVar.blp());
    }
}
