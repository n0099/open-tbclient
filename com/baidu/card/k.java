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
/* loaded from: classes8.dex */
public class k extends h {
    private com.baidu.tbadk.core.data.a ade;
    private ThreadGodReplyLayout adt;
    private an adu;

    public k(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.adt = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.rl() != null) {
                    k.this.rl().a(view, k.this.ade);
                }
            }
        };
        this.adt.setAfterClickListener(onClickListener);
        this.adt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(k.this.mContext).createNormalCfg(k.this.ade.aIu().getTid(), k.this.ade.aIu().aMc().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(k.this.acY.rz());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                k.this.acY.b(new a.C0095a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.adt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, new a.b() { // from class: com.baidu.card.k.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                com.baidu.tieba.card.l.a(k.this.adt.getGodReplyContent(), k.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(an anVar) {
        this.adu = anVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adt.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.adt.setFromCDN(z);
    }

    public void setForm(String str) {
        this.adt.setFrom(str);
    }

    public boolean rt() {
        return this.adt == null || this.adt.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        PostData aMc = aVar.aIu().aMc();
        if (this.adu != null && aMc != null && aMc.aKC() != null && aMc.aKC().getUserId() != null) {
            this.adu.cI("tid", aVar.aIu().tid).cI("post_id", aMc.getId()).cI("uid", aMc.aKC().getUserId());
            com.baidu.tieba.card.r.bEW().e(this.adu);
        }
        this.adt.setData(aVar.aIu());
    }
}
