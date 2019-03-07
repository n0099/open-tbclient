package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class h extends f {
    private ThreadGodReplyLayout XD;
    private am XE;
    private com.baidu.tbadk.core.data.a Xx;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.h(context, d.e.tbds26));
        this.XD = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.rk() != null) {
                    h.this.rk().a(view, h.this.Xx);
                }
            }
        };
        this.XD.setAfterClickListener(onClickListener);
        this.XD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.Xx.WR().getTid(), h.this.Xx.WR().aap().getId() + "", 1, ImageViewerConfig.FROM_OTHER);
                createNormalCfg.setStartFrom(h.this.Xp.rt());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                h.this.Xp.b(new a.C0037a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0037a c0037a) {
                com.baidu.tieba.card.n.a(h.this.XD.getGodReplyContent(), h.this.Xx.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                return false;
            }
        });
    }

    public void a(am amVar) {
        this.XE = amVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.XD.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.XD.setFromCDN(z);
    }

    public void setForm(String str) {
        this.XD.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        PostData aap = aVar.WR().aap();
        if (this.XE != null && aap != null && aap.YR() != null && aap.YR().getUserId() != null) {
            this.XE.bJ("tid", aVar.WR().tid).bJ("post_id", aap.getId()).bJ("uid", aap.YR().getUserId());
            com.baidu.tieba.card.t.aQF().b(this.XE);
        }
        this.XD.setData(aVar.WR());
    }
}
