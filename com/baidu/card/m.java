package com.baidu.card;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes15.dex */
public class m extends h {
    private AbsThreadDataSupport aeY;
    private ThreadGodReplyLayout afs;
    private com.baidu.tbadk.core.util.aq aft;

    public m(Context context) {
        super(context);
        setTopMargin(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26));
        this.afs = new ThreadGodReplyLayout(context);
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.tw() != null) {
                    m.this.tw().a(view, m.this.aeY);
                }
            }
        };
        this.afs.setAfterClickListener(onClickListener);
        this.afs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(m.this.mContext).createNormalCfg(m.this.aeY.bce().getTid(), m.this.aeY.bce().bgh().getId() + "", 1, "other");
                createNormalCfg.setStartFrom(m.this.aeT.tN());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                m.this.aeT.b(new a.C0095a(1));
                onClickListener.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.afs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, new a.b() { // from class: com.baidu.card.m.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                com.baidu.tieba.card.m.a(m.this.afs.getGodReplyContent(), m.this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return false;
            }
        });
    }

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        this.aft = aqVar;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afs.onChangeSkinType();
    }

    public void setFromCDN(boolean z) {
        this.afs.setFromCDN(z);
    }

    public void setForm(String str) {
        this.afs.setFrom(str);
    }

    public boolean tF() {
        return this.afs == null || this.afs.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        PostData bgh = absThreadDataSupport.bce().bgh();
        if (this.aft != null && bgh != null && bgh.beE() != null && bgh.beE().getUserId() != null) {
            this.aft.dD("tid", absThreadDataSupport.bce().tid).dD("post_id", bgh.getId()).dD("uid", bgh.beE().getUserId());
            com.baidu.tieba.card.s.cbY().e(this.aft);
        }
        this.afs.setData(absThreadDataSupport.bce());
    }
}
