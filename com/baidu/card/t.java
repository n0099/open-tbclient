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
    private com.baidu.tbadk.core.data.a agr;
    private ThreadLinkView ahm;
    private TextView ahn;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.ahm = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.ahn = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
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
        if (aVar == null || aVar.bkV() == null) {
            getView().setVisibility(8);
            return;
        }
        this.agr = aVar;
        bz bkV = aVar.bkV();
        com.baidu.tieba.card.m.a(bkV, this.ahn);
        this.ahm.setData(bkV);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahm.onChangeSkinType();
        if (this.agr != null && this.agr.bkV() != null) {
            com.baidu.tieba.card.m.a(this.ahn, this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.ahm.setTag(bdUniqueId);
    }
}
