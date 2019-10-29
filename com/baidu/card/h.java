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
/* loaded from: classes3.dex */
public class h extends f {
    private ThreadGodReplyLayout FE;
    private an FF;
    private com.baidu.tbadk.core.data.a Fx;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.FE = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.lH() != null) {
                    h.this.lH().a(view, h.this.Fx);
                }
            }
        };
        this.FE.setAfterClickListener(onClickListener);
        this.FE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.Fx.agI().getTid(), h.this.Fx.agI().akd().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(h.this.Fp.lR());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                h.this.Fp.b(new a.C0044a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.FE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                com.baidu.tieba.card.n.a(h.this.FE.getGodReplyContent(), h.this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.FF = anVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.FE.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.FE.setFromCDN(z);
    }

    public void setForm(String str) {
        this.FE.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        PostData akd = aVar.agI().akd();
        if (this.FF != null && akd != null && akd.aiG() != null && akd.aiG().getUserId() != null) {
            this.FF.bS("tid", aVar.agI().tid).bS("post_id", akd.getId()).bS("uid", akd.aiG().getUserId());
            com.baidu.tieba.card.t.baw().c(this.FF);
        }
        this.FE.setData(aVar.agI());
    }
}
