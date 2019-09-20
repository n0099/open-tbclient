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
    private com.baidu.tbadk.core.data.a VI;
    private ThreadGodReplyLayout VP;
    private an VQ;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26));
        this.VP = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.qC() != null) {
                    h.this.qC().a(view, h.this.VI);
                }
            }
        };
        this.VP.setAfterClickListener(onClickListener);
        this.VP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.VI.acC().getTid(), h.this.VI.acC().aga().getId() + "", 1, ImageViewerConfig.FROM_OTHER);
                createNormalCfg.setStartFrom(h.this.VA.qM());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                h.this.VA.b(new a.C0038a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.VP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qB() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                com.baidu.tieba.card.n.a(h.this.VP.getGodReplyContent(), h.this.VI.acC().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.VQ = anVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.VP.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.VP.setFromCDN(z);
    }

    public void setForm(String str) {
        this.VP.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VI = aVar;
        PostData aga = aVar.acC().aga();
        if (this.VQ != null && aga != null && aga.aeC() != null && aga.aeC().getUserId() != null) {
            this.VQ.bT("tid", aVar.acC().tid).bT("post_id", aga.getId()).bT("uid", aga.aeC().getUserId());
            com.baidu.tieba.card.t.bat().c(this.VQ);
        }
        this.VP.setData(aVar.acC());
    }
}
