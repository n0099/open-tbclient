package com.baidu.afd.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.c;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<d, FacadeEmptyViewHolder> {
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public FacadeEmptyViewHolder e(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new FacadeEmptyViewHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, FacadeEmptyViewHolder facadeEmptyViewHolder) {
        c.a(dVar);
        return facadeEmptyViewHolder.getView();
    }
}
