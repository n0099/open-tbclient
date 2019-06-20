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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class h extends f {
    private com.baidu.tbadk.core.data.a Vp;
    private ThreadGodReplyLayout Vv;
    private am Vw;

    public h(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26));
        this.Vv = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.qf() != null) {
                    h.this.qf().a(view, h.this.Vp);
                }
            }
        };
        this.Vv.setAfterClickListener(onClickListener);
        this.Vv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mContext).createNormalCfg(h.this.Vp.abv().getTid(), h.this.Vp.abv().aeT().getId() + "", 1, ImageViewerConfig.FROM_OTHER);
                createNormalCfg.setStartFrom(h.this.Vh.qo());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                h.this.Vh.b(new a.C0038a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.Vv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qe() {
        a(1, new a.b() { // from class: com.baidu.card.h.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                com.baidu.tieba.card.n.a(h.this.Vv.getGodReplyContent(), h.this.Vp.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(am amVar) {
        this.Vw = amVar;
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Vv.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.Vv.setFromCDN(z);
    }

    public void setForm(String str) {
        this.Vv.setFrom(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vp = aVar;
        PostData aeT = aVar.abv().aeT();
        if (this.Vw != null && aeT != null && aeT.adv() != null && aeT.adv().getUserId() != null) {
            this.Vw.bT("tid", aVar.abv().tid).bT("post_id", aeT.getId()).bT("uid", aeT.adv().getUserId());
            com.baidu.tieba.card.t.aXP().b(this.Vw);
        }
        this.Vv.setData(aVar.abv());
    }
}
