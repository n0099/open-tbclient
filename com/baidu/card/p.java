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
    private ThreadLinkView KC;
    private TextView KD;
    private com.baidu.tbadk.core.data.a Kc;
    private View mRootView;

    public p(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.KC = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.KD = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (aVar == null || aVar.aAj() == null) {
            getView().setVisibility(8);
            return;
        }
        this.Kc = aVar;
        bj aAj = aVar.aAj();
        com.baidu.tieba.card.l.a(aAj, this.KD);
        this.KC.setData(aAj);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.KC.onChangeSkinType();
        if (this.Kc != null && this.Kc.aAj() != null) {
            com.baidu.tieba.card.l.a(this.KD, this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.KC.setTag(bdUniqueId);
    }
}
