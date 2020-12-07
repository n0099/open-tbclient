package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class t extends b<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private ThreadLinkView ahs;
    private TextView aht;
    private View mRootView;

    public t(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.ahs = (ThreadLinkView) this.mRootView.findViewById(R.id.link_thread_root);
        this.aht = (TextView) this.mRootView.findViewById(R.id.link_seg_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bmn() == null) {
            getView().setVisibility(8);
            return;
        }
        this.agJ = aVar;
        by bmn = aVar.bmn();
        com.baidu.tieba.card.n.a(bmn, this.aht);
        this.ahs.setData(bmn);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahs.onChangeSkinType();
        if (this.agJ != null && this.agJ.bmn() != null) {
            com.baidu.tieba.card.n.a(this.aht, this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        super.setPageUniqueId(bdUniqueId);
        this.ahs.setTag(bdUniqueId);
    }
}
