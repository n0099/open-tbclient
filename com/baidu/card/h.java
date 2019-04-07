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
    private ThreadGodReplyLayout XE;
    private am XF;
    private com.baidu.tbadk.core.data.a Xy;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.h(context, d.e.tbds26));
        this.XE = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.rk() != null) {
                    h.this.rk().a(view, h.this.Xy);
                }
            }
        };
        this.XE.setAfterClickListener(onClickListener);
        this.XE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.Xy.WO().getTid(), h.this.Xy.WO().aam().getId() + "", 1, ImageViewerConfig.FROM_OTHER);
                createNormalCfg.setStartFrom(h.this.Xq.rt());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                h.this.Xq.b(new a.C0039a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.XE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rj() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0039a c0039a) {
                com.baidu.tieba.card.n.a(h.this.XE.getGodReplyContent(), h.this.Xy.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                return false;
            }
        });
    }

    public void a(am amVar) {
        this.XF = amVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.XE.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.XE.setFromCDN(z);
    }

    public void setForm(String str) {
        this.XE.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        PostData aam = aVar.WO().aam();
        if (this.XF != null && aam != null && aam.YO() != null && aam.YO().getUserId() != null) {
            this.XF.bJ("tid", aVar.WO().tid).bJ("post_id", aam.getId()).bJ("uid", aam.YO().getUserId());
            com.baidu.tieba.card.t.aQD().b(this.XF);
        }
        this.XE.setData(aVar.WO());
    }
}
