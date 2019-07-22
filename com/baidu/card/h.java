package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class h extends f {
    private com.baidu.tbadk.core.data.a VJ;
    private ThreadGodReplyLayout VQ;
    private an VR;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26));
        this.VQ = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.qB() != null) {
                    h.this.qB().a(view, h.this.VJ);
                }
            }
        };
        this.VQ.setAfterClickListener(onClickListener);
        this.VQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.VJ.acx().getTid(), h.this.VJ.acx().afV().getId() + "", 1, ImageViewerConfig.FROM_OTHER);
                createNormalCfg.setStartFrom(h.this.VB.qL());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                h.this.VB.b(new a.C0038a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qA() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                com.baidu.tieba.card.n.a(h.this.VQ.getGodReplyContent(), h.this.VJ.acx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.VR = anVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VQ.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.VQ.setFromCDN(z);
    }

    public void setForm(String str) {
        this.VQ.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VJ = aVar;
        PostData afV = aVar.acx().afV();
        if (this.VR != null && afV != null && afV.aex() != null && afV.aex().getUserId() != null) {
            this.VR.bT("tid", aVar.acx().tid).bT("post_id", afV.getId()).bT("uid", afV.aex().getUserId());
            com.baidu.tieba.card.t.aZN().c(this.VR);
        }
        this.VQ.setData(aVar.acx());
    }
}
