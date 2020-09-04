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
/* loaded from: classes15.dex */
public class s extends b<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    private ThreadLinkView afD;
    private TextView afE;
    private View mRootView;

    public s(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.afD = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.afE = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bce() == null) {
            getView().setVisibility(8);
            return;
        }
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        com.baidu.tieba.card.m.a(bce, this.afE);
        this.afD.setData(bce);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.afD.onChangeSkinType();
        if (this.aeY != null && this.aeY.bce() != null) {
            com.baidu.tieba.card.m.a(this.afE, this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.afD.setTag(bdUniqueId);
    }
}
