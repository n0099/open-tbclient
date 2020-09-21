package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class t extends b<AbsThreadDataSupport> {
    private ThreadLinkView afV;
    private TextView afW;
    private AbsThreadDataSupport afq;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.afV = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.afW = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bcY() == null) {
            getView().setVisibility(8);
            return;
        }
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        com.baidu.tieba.card.m.a(bcY, this.afW);
        this.afV.setData(bcY);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afV.onChangeSkinType();
        if (this.afq != null && this.afq.bcY() != null) {
            com.baidu.tieba.card.m.a(this.afW, this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.afV.setTag(bdUniqueId);
    }
}
