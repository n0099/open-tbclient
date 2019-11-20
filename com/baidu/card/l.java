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
    private com.baidu.tbadk.core.data.a EX;
    private ThreadLinkView Fl;
    private TextView Fm;
    private View mRootView;

    public l(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.Fl = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.Fm = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (aVar == null || aVar.agG() == null) {
            getView().setVisibility(8);
            return;
        }
        this.EX = aVar;
        bh agG = aVar.agG();
        com.baidu.tieba.card.n.a(agG, this.Fm);
        this.Fl.setData(agG);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Fl.onChangeSkinType();
        if (this.EX != null && this.EX.agG() != null) {
            com.baidu.tieba.card.n.a(this.Fm, this.EX.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.Fl.setTag(bdUniqueId);
    }
}
