package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes21.dex */
public class ae extends b<bj> {
    private RecommendForumLayout agZ;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.agZ = new RecommendForumLayout(tbPageContext);
        this.agZ.setPageUniqueId(bdUniqueId);
        this.agZ.setShowMore(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.agZ;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agZ.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agZ.setPageUniqueId(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bj bjVar) {
        this.agZ.setData(bjVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.agZ.setOnClickRightArrowListener(onClickListener);
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.agZ.setOnRullOkCallbackr(aVar);
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<bi> fVar) {
        this.agZ.setOnItemCoverListener(fVar);
    }

    public void setEnableShowInto(boolean z) {
        this.agZ.setEnableShowInto(z);
    }

    public void setShowMore(boolean z) {
        this.agZ.setShowMore(z);
    }

    public void setShowSquareEntrance(boolean z) {
        this.agZ.setShowSquareEntrance(z);
    }
}
