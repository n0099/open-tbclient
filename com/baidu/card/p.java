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
/* loaded from: classes8.dex */
public class p extends b<com.baidu.tbadk.core.data.a> {
    private TextView adA;
    private com.baidu.tbadk.core.data.a ada;
    private ThreadLinkView adz;
    private View mRootView;

    public p(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.adz = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.adA = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (aVar == null || aVar.aIw() == null) {
            getView().setVisibility(8);
            return;
        }
        this.ada = aVar;
        bj aIw = aVar.aIw();
        com.baidu.tieba.card.l.a(aIw, this.adA);
        this.adz.setData(aIw);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adz.onChangeSkinType();
        if (this.ada != null && this.ada.aIw() != null) {
            com.baidu.tieba.card.l.a(this.adA, this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.adz.setTag(bdUniqueId);
    }
}
