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
/* loaded from: classes20.dex */
public class n extends i {
    private com.baidu.tbadk.core.data.a afN;
    private ThreadGodReplyLayout agi;
    private com.baidu.tbadk.core.util.ar agj;

    public n(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.M_H_X003));
        this.agi = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.tB() != null) {
                    n.this.tB().a(view, n.this.afN);
                }
            }
        };
        this.agi.setAfterClickListener(onClickListener);
        this.agi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(n.this.mContext).createNormalCfg(n.this.afN.bjd().getTid(), n.this.afN.bjd().bnh().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(n.this.afI.tS());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                n.this.afI.b(new a.C0096a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, new a.b() { // from class: com.baidu.card.n.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                com.baidu.tieba.card.n.a(n.this.agi.getGodReplyContent(), n.this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.ar arVar) {
        this.agj = arVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agi.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.agi.setFromCDN(z);
    }

    public void setForm(String str) {
        this.agi.setFrom(str);
    }

    public boolean tK() {
        return this.agi == null || this.agi.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        PostData bnh = aVar.bjd().bnh();
        if (this.agj != null && bnh != null && bnh.blC() != null && bnh.blC().getUserId() != null) {
            this.agj.dR("tid", aVar.bjd().tid).dR("post_id", bnh.getId()).dR("uid", bnh.blC().getUserId());
            com.baidu.tieba.card.t.cnT().e(this.agj);
        }
        this.agi.setData(aVar.bjd());
    }
}
