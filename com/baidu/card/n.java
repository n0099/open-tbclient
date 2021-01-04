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
    private ThreadGodReplyLayout ahR;
    private com.baidu.tbadk.core.util.aq ahS;
    private com.baidu.tbadk.core.data.a ahi;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.ahR = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tc() != null) {
                    n.this.tc().a(view, n.this.ahi);
                }
            }
        };
        this.ahR.setAfterClickListener(onClickListener);
        this.ahR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.ahi.boO().getTid(), n.this.ahi.boO().bsW().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.ahd.tu());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.ahd.b(new a.C0090a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.ahR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                com.baidu.tieba.card.m.a(n.this.ahR.getGodReplyContent(), n.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.ahS = aqVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahR.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.ahR.setFromCDN(z);
    }

    public void setForm(String str) {
        this.ahR.setFrom(str);
    }

    public boolean tl() {
        return this.ahR == null || this.ahR.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        PostData bsW = aVar.boO().bsW();
        if (this.ahS != null && bsW != null && bsW.brq() != null && bsW.brq().getUserId() != null) {
            this.ahS.dX("tid", aVar.boO().tid).dX("post_id", bsW.getId()).dX("uid", bsW.brq().getUserId());
            com.baidu.tieba.card.s.cva().e(this.ahS);
        }
        this.ahR.setData(aVar.boO());
    }
}
