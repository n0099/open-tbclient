package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agj;
    private ThreadLinkView aha;
    private TextView ahb;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.aha = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.ahb = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bln() == null) {
            getView().setVisibility(8);
            return;
        }
        this.agj = aVar;
        cb bln = aVar.bln();
        com.baidu.tieba.card.m.a(bln, this.ahb);
        this.aha.setData(bln);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aha.onChangeSkinType();
        if (this.agj != null && this.agj.bln() != null) {
            com.baidu.tieba.card.m.a(this.ahb, this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.aha.setTag(bdUniqueId);
    }
}
