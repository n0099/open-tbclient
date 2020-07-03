package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class r extends b<AbsThreadDataSupport> {
    private ThreadLinkView aeC;
    private TextView aeD;
    private AbsThreadDataSupport aea;
    private View mRootView;

    public r(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.aeC = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.aeD = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (absThreadDataSupport == null || absThreadDataSupport.aPS() == null) {
            getView().setVisibility(8);
            return;
        }
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        com.baidu.tieba.card.m.a(aPS, this.aeD);
        this.aeC.setData(aPS);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aeC.onChangeSkinType();
        if (this.aea != null && this.aea.aPS() != null) {
            com.baidu.tieba.card.m.a(this.aeD, this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.aeC.setTag(bdUniqueId);
    }
}
