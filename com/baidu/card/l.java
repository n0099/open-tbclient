package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends b<com.baidu.tbadk.core.data.a> {
    private ThreadLinkView XL;
    private TextView XM;
    private com.baidu.tbadk.core.data.a Xy;
    private View mRootView;

    public l(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(d.h.card_link_layout, (ViewGroup) null, true);
        this.XL = (ThreadLinkView) this.mRootView.findViewById(d.g.link_thread_root);
        this.XM = (TextView) this.mRootView.findViewById(d.g.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.WR() == null) {
            getView().setVisibility(8);
            return;
        }
        this.Xy = aVar;
        bg WR = aVar.WR();
        com.baidu.tieba.card.n.b(WR, this.XM);
        this.XL.setData(WR);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.XL.onChangeSkinType();
        if (this.Xy != null && this.Xy.WR() != null) {
            com.baidu.tieba.card.n.a(this.XM, this.Xy.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.XL.setTag(bdUniqueId);
    }
}
