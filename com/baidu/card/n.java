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
/* loaded from: classes21.dex */
public class n extends i {
    private com.baidu.tbadk.core.data.a agJ;
    private ThreadGodReplyLayout ahg;
    private com.baidu.tbadk.core.util.ar ahh;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.ahg = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tE() != null) {
                    n.this.tE().a(view, n.this.agJ);
                }
            }
        };
        this.ahg.setAfterClickListener(onClickListener);
        this.ahg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.agJ.bmn().getTid(), n.this.agJ.bmn().bqu().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.agE.tV());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.agE.b(new a.C0097a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.ahg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                com.baidu.tieba.card.n.a(n.this.ahg.getGodReplyContent(), n.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ar arVar) {
        this.ahh = arVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahg.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.ahg.setFromCDN(z);
    }

    public void setForm(String str) {
        this.ahg.setFrom(str);
    }

    public boolean tN() {
        return this.ahg == null || this.ahg.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        PostData bqu = aVar.bmn().bqu();
        if (this.ahh != null && bqu != null && bqu.boP() != null && bqu.boP().getUserId() != null) {
            this.ahh.dY("tid", aVar.bmn().tid).dY("post_id", bqu.getId()).dY("uid", bqu.boP().getUserId());
            com.baidu.tieba.card.t.csg().e(this.ahh);
        }
        this.ahg.setData(aVar.bmn());
    }
}
