package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class r extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private ThreadLinkView aes;
    private TextView aet;
    private View mRootView;

    public r(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.aes = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.aet = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (absThreadDataSupport == null || absThreadDataSupport.aTN() == null) {
            getView().setVisibility(8);
            return;
        }
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        com.baidu.tieba.card.m.a(aTN, this.aet);
        this.aes.setData(aTN);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aes.onChangeSkinType();
        if (this.adQ != null && this.adQ.aTN() != null) {
            com.baidu.tieba.card.m.a(this.aet, this.adQ.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.aes.setTag(bdUniqueId);
    }
}
