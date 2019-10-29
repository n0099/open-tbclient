package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l extends b<com.baidu.tbadk.core.data.a> {
    private ThreadLinkView FL;
    private TextView FM;
    private com.baidu.tbadk.core.data.a Fx;
    private View mRootView;

    public l(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.FL = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.FM = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.agI() == null) {
            getView().setVisibility(8);
            return;
        }
        this.Fx = aVar;
        bh agI = aVar.agI();
        com.baidu.tieba.card.n.a(agI, this.FM);
        this.FL.setData(agI);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.FL.onChangeSkinType();
        if (this.Fx != null && this.Fx.agI() != null) {
            com.baidu.tieba.card.n.a(this.FM, this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.FL.setTag(bdUniqueId);
    }
}
