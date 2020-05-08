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
    private ThreadLinkView adC;
    private TextView adD;
    private com.baidu.tbadk.core.data.a ade;
    private View mRootView;

    public p(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.adC = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.adD = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.aIu() == null) {
            getView().setVisibility(8);
            return;
        }
        this.ade = aVar;
        bj aIu = aVar.aIu();
        com.baidu.tieba.card.l.a(aIu, this.adD);
        this.adC.setData(aIu);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adC.onChangeSkinType();
        if (this.ade != null && this.ade.aIu() != null) {
            com.baidu.tieba.card.l.a(this.adD, this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.adC.setTag(bdUniqueId);
    }
}
