package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class p extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    private ThreadLinkView Kg;
    private TextView Kh;
    private View mRootView;

    public p(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.Kg = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.Kh = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.axQ() == null) {
            getView().setVisibility(8);
            return;
        }
        this.JH = aVar;
        bj axQ = aVar.axQ();
        com.baidu.tieba.card.l.a(axQ, this.Kh);
        this.Kg.setData(axQ);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.Kg.onChangeSkinType();
        if (this.JH != null && this.JH.axQ() != null) {
            com.baidu.tieba.card.l.a(this.Kh, this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.Kg.setTag(bdUniqueId);
    }
}
