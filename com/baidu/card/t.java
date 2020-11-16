package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class t extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a afN;
    private ThreadLinkView agt;
    private TextView agu;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.agt = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.agu = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bjd() == null) {
            getView().setVisibility(8);
            return;
        }
        this.afN = aVar;
        bx bjd = aVar.bjd();
        com.baidu.tieba.card.n.a(bjd, this.agu);
        this.agt.setData(bjd);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agt.onChangeSkinType();
        if (this.afN != null && this.afN.bjd() != null) {
            com.baidu.tieba.card.n.a(this.agu, this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.agt.setTag(bdUniqueId);
    }
}
