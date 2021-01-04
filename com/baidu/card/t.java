package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    private ThreadLinkView aie;
    private TextView aif;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.aie = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.aif = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.boO() == null) {
            getView().setVisibility(8);
            return;
        }
        this.ahi = aVar;
        bz boO = aVar.boO();
        com.baidu.tieba.card.m.a(boO, this.aif);
        this.aie.setData(boO);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aie.onChangeSkinType();
        if (this.ahi != null && this.ahi.boO() != null) {
            com.baidu.tieba.card.m.a(this.aif, this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.aie.setTag(bdUniqueId);
    }
}
