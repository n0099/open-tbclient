package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class q extends b<AbsThreadDataSupport> {
    private ThreadLinkView adW;
    private TextView adX;
    private AbsThreadDataSupport adw;
    private View mRootView;

    public q(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.adW = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.adX = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aOi() == null) {
            getView().setVisibility(8);
            return;
        }
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        com.baidu.tieba.card.m.a(aOi, this.adX);
        this.adW.setData(aOi);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.adW.onChangeSkinType();
        if (this.adw != null && this.adw.aOi() != null) {
            com.baidu.tieba.card.m.a(this.adX, this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.adW.setTag(bdUniqueId);
    }
}
